package com.evanadwyer.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.evanadwyer.core.database.dao.AnalyticsDao
import com.evanadwyer.core.database.dao.RunDao
import com.evanadwyer.core.database.dao.RunPendingSyncDao
import com.evanadwyer.core.database.entity.DeletedRunSyncEntity
import com.evanadwyer.core.database.entity.RunEntity
import com.evanadwyer.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
    abstract val analyticsDao: AnalyticsDao
}