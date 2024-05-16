package com.evanadwyer.run.data.di

import com.evanadwyer.run.data.CreateRunWorker
import com.evanadwyer.run.data.FetchRunsWorker
import com.evanadwyer.run.data.DeleteRunWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::FetchRunsWorker)
    workerOf(::DeleteRunWorker)
}