package com.training.e_commerceandroidtraining.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    val DATASTORE_KEY = "commerce datastore"

    @Provides
    fun provideDataStoreInstance (context: Context):DataStore<Preferences>{
        val context.dataStore by preferencesDataStore(name = DATASTORE_KEY)
        return context.createDataStore(name = "my_preference_datastore")
    }
}

object PreferenceDataStore {
    private var instance: DataStore<Preferences>? = null

    fun getInstance(context: Context): DataStore<Preferences> {
        return instance ?: createDataStore(context).also { instance = it }
    }

    private fun createDataStore(context: Context): DataStore<Preferences> {
        return context.createDataStore(name = "my_preference_datastore")
    }
}
