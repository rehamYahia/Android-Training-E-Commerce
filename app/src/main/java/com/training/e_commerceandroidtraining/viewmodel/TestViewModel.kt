package com.training.e_commerceandroidtraining.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TestViewModel():ViewModel() {

    var email :MutableStateFlow<String> = MutableStateFlow("")

    var password :MutableStateFlow<String> = MutableStateFlow("")

    fun test(){
        viewModelScope.launch {
            email.collect{
                Log.d("here" , "your email is : $it")
            }
        }
    }

}