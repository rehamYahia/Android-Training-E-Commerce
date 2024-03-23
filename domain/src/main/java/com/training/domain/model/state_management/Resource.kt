package com.training.domain.model.state_management

import java.lang.Exception

sealed class Resource<T> (private val data:T ?= null, private val exception:Exception  ?= null){


    class Loading<T>(data:T?=null) :Resource<T>(data)

    class Success<T>(data : T):Resource<T>(data)

    class Error<T>(exception: Exception, data: T? = null) : Resource<T>(data, exception)

    override fun toString(): String {
        return when(this){
            is Loading -> "Loading[data $data]"
            is Success ->"Success[data $data]"
            is Error -> "Error[data: $data , message:$exception ]"
        }
    }
}

