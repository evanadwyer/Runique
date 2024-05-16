package com.evanadwyer.analytics.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel

class AnalyticsDashboardViewModel(

) : ViewModel() {

    var state by mutableStateOf<AnalyticsDashboardState?>(null)
        private set

//    private val eventChannel = Channel<AnalyticsDashboardEvent>()
//    val events = eventChannel.receiveAsFlow()


    fun onAction(action: AnalyticsAction) {
        when (action) {

            else -> Unit
        }
    }
}