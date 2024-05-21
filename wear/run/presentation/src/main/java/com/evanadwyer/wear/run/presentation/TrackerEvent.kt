package com.evanadwyer.wear.run.presentation

import com.evanadwyer.core.presentation.ui.UiText

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
    data class Error(val message: UiText): TrackerEvent
}