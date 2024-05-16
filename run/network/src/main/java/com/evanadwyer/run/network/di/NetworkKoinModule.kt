package com.evanadwyer.run.network.di

import com.evanadwyer.core.domain.run.RemoteRunDataSource
import com.evanadwyer.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}