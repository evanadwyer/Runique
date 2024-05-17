package com.evanadwyer.analytics.presentation

import com.evanadwyer.analytics.domain.AnalyticsValues
import com.evanadwyer.core.presentation.ui.formatted
import com.evanadwyer.core.presentation.ui.toFormattedKm
import com.evanadwyer.core.presentation.ui.toFormattedKmh
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.time.DurationUnit

fun Duration.toFormattedTotalTime(): String {
    val days = toLong(DurationUnit.DAYS)
    val hours = toLong(DurationUnit.HOURS) % 24
    val minutes = toLong(DurationUnit.MINUTES) % 60
    return "${days}d ${hours}h ${minutes}m"
}

fun AnalyticsValues.toAnalyticsDashboardState(): AnalyticsDashboardState {
    return AnalyticsDashboardState(
        totalDistanceRan = (totalDistanceRan / 1000.0).toFormattedKm(),
        totalTimeRan = totalTimeRun.toFormattedTotalTime(),
        fastestEverRun = fastestEverRun.toFormattedKmh(),
        avgDistance = (avgDistancePerRun / 1000.0).toFormattedKm(),
        avgPace = avgPacePerRun.seconds.formatted()
    )
}