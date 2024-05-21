package com.evanadwyer.core.connectivity.data.di

import com.evanadwyer.core.connectivity.data.WearNodeDiscovery
import com.evanadwyer.core.connectivity.data.messaging.WearMessagingClient
import com.evanadwyer.core.connectivity.domain.NodeDiscovery
import com.evanadwyer.core.connectivity.domain.messaging.MessagingClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreConnectivityDataModule = module {
    singleOf(::WearNodeDiscovery).bind<NodeDiscovery>()
    singleOf(::WearMessagingClient).bind<MessagingClient>()
}