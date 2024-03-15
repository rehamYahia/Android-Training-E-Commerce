package com.training.data.`repo-imp`.datasource.datastore


import android.content.Context
import androidx.datastore.core.DataStore
import com.training.data.`repo-imp`.datasource.datastore.UserDataSource.DATASTORE_KEY
import java.util.prefs.Preferences


object UserDataSource {
    val DATASTORE_KEY = "commerce datastore"
    val USER_LOGIN_STATE = "login state"
}

// At the top level of your kotlin file:
//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")