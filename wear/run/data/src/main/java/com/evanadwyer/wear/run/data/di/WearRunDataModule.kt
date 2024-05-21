package com.evanadwyer.wear.run.data.di

import com.evanadwyer.wear.run.data.HealthServicesExerciseTracker
import com.evanadwyer.wear.run.data.WatchToPhoneConnector
import com.evanadwyer.wear.run.domain.ExerciseTracker
import com.evanadwyer.wear.run.domain.PhoneConnector
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val wearRunDataModule = module {
    singleOf(::HealthServicesExerciseTracker).bind<ExerciseTracker>()
    singleOf(::WatchToPhoneConnector).bind<PhoneConnector>()
}