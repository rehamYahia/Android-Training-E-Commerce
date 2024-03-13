package com.training.e_commerceandroidtraining.ui.activities

import android.animation.ObjectAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.fragment.NavHostFragment
import com.training.e_commerceandroidtraining.R

class AuthenticationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication_screen)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.auth_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

    }

    private fun initSplashScreen(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            installSplashScreen()
            splashScreen.setOnExitAnimationListener {splashScreenView->
            val slideup = ObjectAnimator.ofFloat(splashScreenView , View.TRANSLATION_Y , 0f , -splashScreenView.height.toFloat())
                slideup.interpolator = AnticipateInterpolator()
                slideup.duration = 1000
                slideup.doOnEnd { splashScreenView.remove() }
                slideup.start()
            }
        }else{
            setTheme(R.style.Base_Theme_ECommerceAndroidTraining)
        }
    }
}