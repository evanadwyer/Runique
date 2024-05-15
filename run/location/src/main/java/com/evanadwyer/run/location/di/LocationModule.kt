package com.evanadwyer.run.location.di

import com.evanadwyer.run.domain.LocationObserver
import com.evanadwyer.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}