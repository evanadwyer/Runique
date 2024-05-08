package com.evanadwyer.auth.presentation.login

import com.evanadwyer.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class Error(val error: UiText): LoginEvent
    data object LoginSuccess: LoginEvent
}