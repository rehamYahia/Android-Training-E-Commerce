package com.training.domain.`repo-interfaces`

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun isUserLogin(): Flow<Boolean>
}