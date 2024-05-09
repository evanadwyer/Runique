package com.evanadwyer.core.domain.location

data class LocationWithAltitude(
    val location: Location,
    val altitudeMeters: Double
)
