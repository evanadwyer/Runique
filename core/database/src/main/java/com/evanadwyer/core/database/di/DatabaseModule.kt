package com.evanadwyer.core.database.di

import androidx.room.Room
import com.evanadwyer.core.database.RoomLocalRunDataSource
import com.evanadwyer.core.database.RunDatabase
import com.evanadwyer.core.domain.run.LocalRunDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            RunDatabase::class.java,
            "run.db"
        ).build()
    }
    single { get<RunDatabase>().runDao }

    singleOf(::RoomLocalRunDataSource).bind<LocalRunDataSource>()
}