package com.training.e_commerceandroidtraining.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.training.domain.usecase.AuthUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class AuthViewModel(  val authUseCase: AuthUseCase) :ViewModel() {
 suspend fun IsLogin(): Flow<Boolean?> =  authUseCase.isUserLoggedIn()

 suspend fun SaveLoginState(loginState:Boolean){
     viewModelScope.launch (Dispatchers.IO){
         authUseCase.saveIsLoggedIn(loginState)
     }
 }
}

class AuthViewModelFactory(
    private val authUseCase: AuthUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return LoginViewModel(authUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}