package com.evanadwyer.wear.run.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class TrackerViewModel(

) : ViewModel() {

    var state by mutableStateOf(TrackerState())
        private set

    private val eventChannel = Channel<TrackerEvent>()
    val events = eventChannel.receiveAsFlow()


    fun onAction(action: TrackerAction) {
        when (action) {

            else -> Unit
        }
    }
}