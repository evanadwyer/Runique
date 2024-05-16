package com.evanadwyer.core.data.di

import com.evanadwyer.core.data.auth.EncryptedSessionStorage
import com.evanadwyer.core.data.networking.HttpClientFactory
import com.evanadwyer.core.data.run.OfflineFirstRunRepository
import com.evanadwyer.core.domain.SessionStorage
import com.evanadwyer.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}