package com.evanadwyer.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.evanadwyer.core.database.dao.RunPendingSyncDao
import com.evanadwyer.core.database.mappers.toRun
import com.evanadwyer.core.domain.run.RemoteRunDataSource

class CreateRunWorker(
    context: Context,
    private val params: WorkerParameters,
    private val remoteRunDataSource: RemoteRunDataSource,
    private val pendingSyncDao: RunPendingSyncDao,
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }

        val pendingRunId = params.inputData.getString(RUN_ID) ?: return Result.failure()
        val pendingRunEntity = pendingSyncDao.getRunPendingSyncEntity(pendingRunId)
            ?: return Result.failure()

        val run = pendingRunEntity.run.toRun()
        return when (val result =
            remoteRunDataSource.postRun(run, pendingRunEntity.mapPictureBytes)) {
            is com.evanadwyer.core.domain.util.Result.Error -> {
                result.error.toWorkerResult()
            }

            is com.evanadwyer.core.domain.util.Result.Success -> {
                pendingSyncDao.deleteRunPendingSyncEntity(pendingRunId)
                Result.success()
            }
        }
    }

    companion object {
        const val RUN_ID = "RUN_ID"
    }
}