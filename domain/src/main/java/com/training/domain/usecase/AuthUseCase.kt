package com.training.domain.usecase

import com.training.domain.`repo-interfaces`.LoginRepository
import kotlinx.coroutines.flow.Flow

class AuthUseCase(private val loginRepository: LoginRepository) {
    suspend fun isUserLoggedIn(): Flow<Boolean?> {
        return loginRepository.isUserLoggedIn()
    }

    suspend fun  saveIsLoggedIn(loginState:Boolean){
        loginRepository.saveLoginState(loginState)
    }
}