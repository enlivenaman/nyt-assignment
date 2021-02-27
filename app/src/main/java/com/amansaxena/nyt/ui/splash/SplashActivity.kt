package com.amansaxena.nyt.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.amansaxena.nyt.R
import com.amansaxena.nyt.di.component.ActivityComponent
import com.amansaxena.nyt.ui.MainActivity
import com.amansaxena.nyt.ui.base.BaseActivity
import com.amansaxena.nyt.ui.splash.SplashViewModel
import com.amansaxena.nyt.util.common.Event

class SplashActivity : BaseActivity<SplashViewModel>() {

    companion object {
        const val TAG = "SplashActivity"
    }

    override fun provideLayoutId(): Int = R.layout.activity_splash

    override fun injectDependencies(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }

    override fun setupView(savedInstanceState: Bundle?) {
    }

    override fun setupObservers() {
        // Event is used by the view model to tell the activity to launch another activity
        // view model also provided the Bundle in the event that is needed for the Activity
        viewModel.launchDummy.observe(this, Observer<Event<Map<String, String>>> {
            it.getIfNotHandled().run {
                startActivity(Intent(applicationContext, MainActivity::class.java))
            }
        })
    }
}