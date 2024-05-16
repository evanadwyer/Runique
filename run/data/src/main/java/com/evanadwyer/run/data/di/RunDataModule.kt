package com.evanadwyer.run.data.di

import com.evanadwyer.core.domain.run.SyncRunScheduler
import com.evanadwyer.run.data.CreateRunWorker
import com.evanadwyer.run.data.FetchRunsWorker
import com.evanadwyer.run.data.DeleteRunWorker
import com.evanadwyer.run.data.SyncRunWorkerScheduler
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}