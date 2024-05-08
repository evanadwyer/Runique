package com.evanadwyer.auth.domain

import com.evanadwyer.core.domain.util.DataError
import com.evanadwyer.core.domain.util.EmptyResult

interface AuthRepository {

    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}