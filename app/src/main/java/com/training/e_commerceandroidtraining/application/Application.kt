package com.training.e_commerceandroidtraining.application

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.reactivex.schedulers.Schedulers


class MyApplication:android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        lisenToNetworkConnectivity()

            }
    }

   @SuppressLint("CheckResult")
   private fun lisenToNetworkConnectivity(){
       ReactiveNetwork
           .observeInternetConnectivity()
           .subscribeOn(Schedulers.io())
           .observeOn(Schedulers.io())
           .subscribe{isConnected:Boolean ->
               Log.d(TAG,"connected to internet:$isConnected")
               FirebaseCrashlytics.getInstance().setCustomKey("connected to internet",isConnected)
   }

}