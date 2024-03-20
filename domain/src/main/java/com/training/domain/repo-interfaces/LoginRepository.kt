package com.training.domain.`repo-interfaces`

import android.content.Context
import kotlinx.coroutines.flow.Flow


interface LoginRepository {
    suspend fun saveLoginState(isLoggedIn:Boolean)
    suspend fun saveUserID(userId:String)
    suspend fun isUserLoggedIn():Flow<Boolean?>
    suspend fun getUserID():Flow<String?>
}