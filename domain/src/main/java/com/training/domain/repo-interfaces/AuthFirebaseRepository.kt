package com.training.domain.`repo-interfaces`

import com.training.domain.model.state_management.Resource
import kotlinx.coroutines.flow.Flow

interface AuthFirebaseRepository {
    suspend fun LoginWithEmailAndPassword(email:String , Password:String): Flow<Resource<String>>
}