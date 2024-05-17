package com.evanadwyer.anaytics.data.di

import com.evanadwyer.analytics.domain.AnalyticsRepository
import com.evanadwyer.anaytics.data.RoomAnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
}