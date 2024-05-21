package com.evanadwyer.wear.run.domain

import com.evanadwyer.core.connectivity.domain.DeviceNode
import com.evanadwyer.core.connectivity.domain.messaging.MessagingAction
import com.evanadwyer.core.connectivity.domain.messaging.MessagingError
import com.evanadwyer.core.domain.util.EmptyResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface PhoneConnector {
    val connectedNode: StateFlow<DeviceNode?>
    val messagingActions: Flow<MessagingAction>

    suspend fun sendActionToPhone(action: MessagingAction): EmptyResult<MessagingError>
}