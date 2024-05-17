package com.evanadwyer.analytics.domain

interface AnalyticsRepository {
    suspend fun getAnalyticsValues(): AnalyticsValues
}