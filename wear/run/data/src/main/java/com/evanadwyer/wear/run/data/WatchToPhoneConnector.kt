package com.evanadwyer.wear.run.data

import com.evanadwyer.core.connectivity.domain.DeviceNode
import com.evanadwyer.core.connectivity.domain.DeviceType
import com.evanadwyer.core.connectivity.domain.NodeDiscovery
import com.evanadwyer.wear.run.domain.PhoneConnector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class WatchToPhoneConnector(
    nodeDiscovery: NodeDiscovery,
    applicationScope: CoroutineScope
) : PhoneConnector {

    private val _connectedNode = MutableStateFlow<DeviceNode?>(null)
    override val connectedNode = _connectedNode.asStateFlow()

    val messagingActions = nodeDiscovery
        .observeConnectedDevices(DeviceType.WATCH)
        .onEach { connectedNodes ->
            val node = connectedNodes.firstOrNull()
            if (node != null && node.isNearby) {
                _connectedNode.value = node
            }
        }
        .launchIn(applicationScope)
}