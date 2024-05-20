package com.evanadwyer.wear.run.presentation

sealed interface TrackerEvent {
    data object RunFinished: TrackerEvent
}