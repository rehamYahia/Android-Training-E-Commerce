package com.training.e_commerceandroidtraining

import android.animation.ObjectAnimator
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnticipateInterpolator
import android.widget.TextView
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.training.e_commerceandroidtraining.utils.CrashLyticsUtils
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class AuthenticationScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        initSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication_screen)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
//       findViewById<TextView>(R.id.text).setOnClickListener{
//           Log.d("NavigationScreen" , "crash")
//           lifecycleScope.launch(Main) {
//               CrashLyticsUtils().sendLogsToCrashlytics("Crash button clicked" ,"button" , "clicked")
//           }
//        throw java.lang.RuntimeException("test crash")
//       }
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