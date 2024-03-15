package com.training.data.`repo-imp`.`repo-imp`

import com.training.domain.`repo-interfaces`.AuthRepository
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImp:AuthRepository {
    override suspend fun isUserLogin(): Flow<Boolean> {

    }
}