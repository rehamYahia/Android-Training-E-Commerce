package com.training.data.`repo-imp`.`repo-imp`


import com.training.domain.`repo-interfaces`.LoginRepository
import com.training.ecommerce.data.datasource.datastore.UserPreferencesDataSource
import kotlinx.coroutines.flow.Flow


 class LoginRepositoryImp(  private val userPreferencesDataSource: UserPreferencesDataSource ) :LoginRepository{

    override suspend fun saveLoginState(isLoggedIn: Boolean) {
        userPreferencesDataSource.saveLoginState(isLoggedIn)
    }

    override suspend fun saveUserID(userId: String) {
        userPreferencesDataSource.saveUserID(userId)
    }

    override suspend fun isUserLoggedIn(): Flow<Boolean> {
      return  userPreferencesDataSource.isUserLoggedIn
    }

    override suspend fun getUserID(): Flow<String?> {
       return userPreferencesDataSource.userID
    }


}