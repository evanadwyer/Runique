package com.evanadwyer.auth.data

import com.evanadwyer.auth.domain.AuthRepository
import com.evanadwyer.core.data.networking.post
import com.evanadwyer.core.domain.util.DataError
import com.evanadwyer.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImplementation(
    private val httpClient: HttpClient
): AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit> (
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}