package com.evanadwyer.wear.run.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.evanadwyer.wear.run.domain.ExerciseTracker
import com.evanadwyer.wear.run.domain.PhoneConnector
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TrackerViewModel(
    private val exerciseTracker: ExerciseTracker,
    private val phoneConnector: PhoneConnector,
) : ViewModel() {

    var state by mutableStateOf(TrackerState())
        private set

    private val hasBodySensorPermission = MutableStateFlow(false)

    init {
        phoneConnector
            .connectedNode
            .filterNotNull()
            .onEach { connectedNode ->
                state = state.copy(
                    isConnectedPhoneNearby = connectedNode.isNearby
                )
            }
            .launchIn(viewModelScope)
    }

    private val eventChannel = Channel<TrackerEvent>()
    val events = eventChannel.receiveAsFlow()


    fun onAction(action: TrackerAction) {
        when (action) {
            is TrackerAction.OnBodySensorPermissionResult -> {
                hasBodySensorPermission.value = action.isGranted
                if (action.isGranted) {
                    viewModelScope.launch {
                        val isHeartRateTrackingSupported =
                            exerciseTracker.isHeartRateTrackingSupported()
                        state = state.copy(
                            canTrackHeartRate = isHeartRateTrackingSupported
                        )
                    }
                }
            }

            TrackerAction.OnFinishRunClick -> Unit
            TrackerAction.OnToggleRunClick -> Unit
        }
    }
}