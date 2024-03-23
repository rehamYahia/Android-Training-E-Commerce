package com.training.data.`repo-imp`.`repo-imp`

import com.google.firebase.auth.FirebaseAuth
import com.training.domain.model.state_management.Resource
import com.training.domain.`repo-interfaces`.AuthFirebaseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.lang.Exception

class AuthFirebaseRepositoryImp(val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()):AuthFirebaseRepository{
    override suspend fun LoginWithEmailAndPassword(
        email: String,
        Password: String
    ): Flow<Resource<String>> = flow {
        try {
            emit(Resource.Loading())
            val authResult = firebaseAuth.signInWithEmailAndPassword(email,Password).await()
            authResult.user?.let {user ->
                emit(Resource.Success(user.uid))
            }
            authResult.user?: kotlin.run {
                emit(Resource.Error(Exception("user not found")))
            }
        }catch (e:Exception){
            emit(Resource.Error(e))
        }
    }
}