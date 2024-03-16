package com.training.data.`repo-imp`.datasource.datastore

import android.content.Context
import com.training.data.`repo-imp`.datasource.datastore.UserDataSource.DATASTORE_KEY
import androidx.datastore.preferences.preferencesDataStore


object UserDataSource {

    val USER_LOGIN_STATE = "login state"
}

 val Context.dataStore by preferencesDataStore(name = DATASTORE_KEY)


