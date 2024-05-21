package com.evanadwyer.core.connectivity.domain.messaging

import com.evanadwyer.core.domain.util.Error

enum class MessagingError: Error {
    CONNECTION_INTERRUPTED,
    DISCONNECTED,
    UNKNOWN
}