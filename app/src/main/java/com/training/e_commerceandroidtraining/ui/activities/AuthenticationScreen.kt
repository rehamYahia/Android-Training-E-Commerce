package com.training.e_commerceandroidtraining.ui.activities

import android.animation.ObjectAnimator
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.viewModels
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.training.data.`repo-imp`.`repo-imp`.LoginRepositoryImp
import com.training.domain.usecase.AuthUseCase
import com.training.e_commerceandroidtraining.R
import com.training.e_commerceandroidtraining.viewmodel.AuthViewModel
import com.training.e_commerceandroidtraining.viewmodel.AuthViewModelFactory
import com.training.e_commerceandroidtraining.viewmodel.LoginViewModel
import com.training.e_commerceandroidtraining.viewmodel.LoginViewModelFactory
import com.training.ecommerce.data.datasource.datastore.UserPreferencesDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AuthenticationScreen : AppCompatActivity() {
    private val authViewModel: AuthViewModel by viewModels {
        AuthViewModelFactory(AuthUseCase(LoginRepositoryImp(UserPreferencesDataSource(this))))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        initSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication_screen)
        lifecycleScope.launch(Dispatchers.Main) {
            val isLoggedIn = authViewModel.IsLogin().first()
            if(isLoggedIn == true){
                goToHomeActivity()
            }else{
                setContentView(R.layout.activity_authentication_screen)
            }
        }
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

    private fun goToHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val options = ActivityOptions.makeCustomAnimation(
            this, android.R.anim.fade_in, android.R.anim.fade_out
        )
        startActivity(intent, options.toBundle())
        finish()
    }
}