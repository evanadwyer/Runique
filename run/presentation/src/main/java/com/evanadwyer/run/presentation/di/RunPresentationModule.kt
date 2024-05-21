package com.evanadwyer.run.presentation.di

import com.evanadwyer.run.domain.RunningTracker
import com.evanadwyer.run.presentation.active_run.ActiveRunViewModel
import com.evanadwyer.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)
    single {
        get<RunningTracker>().elapsedTime
    }

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}