package com.evanadwyer.run.location

import android.location.Location
import com.evanadwyer.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = com.evanadwyer.core.domain.location.Location(
            latitude = latitude,
            longitude = longitude
        ),
        altitudeMeters = altitude
    )
}