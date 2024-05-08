package com.evanadwyer.core.data.di

import com.evanadwyer.core.data.auth.EncryptedSessionStorage
import com.evanadwyer.core.data.networking.HttpClientFactory
import com.evanadwyer.core.domain.SessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}