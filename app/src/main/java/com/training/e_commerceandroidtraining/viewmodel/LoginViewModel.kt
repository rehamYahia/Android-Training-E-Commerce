package com.training.e_commerceandroidtraining.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.training.domain.usecase.AuthUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoginViewModel(
    val authUseCase: AuthUseCase
) : ViewModel() {


    fun getFakeData() {
        viewModelScope.launch {
            delay(5000)
            Log.d(TAG, "getFakeData: ")
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}

class LoginViewModelFactory(
    private val authUseCase: AuthUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST") return LoginViewModel(authUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}