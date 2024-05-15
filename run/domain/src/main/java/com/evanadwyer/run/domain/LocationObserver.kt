package com.evanadwyer.run.domain

import com.evanadwyer.core.domain.location.LocationWithAltitude
import kotlinx.coroutines.flow.Flow

interface LocationObserver {
    fun observerLocation(interval: Long): Flow<LocationWithAltitude>
}