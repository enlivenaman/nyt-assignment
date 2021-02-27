package com.amansaxena.nyt.di.component

import com.amansaxena.nyt.di.ActivityScope
import com.amansaxena.nyt.di.module.ActivityModule
import com.amansaxena.nyt.ui.MainActivity
import com.amansaxena.nyt.ui.splash.SplashActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun inject(activity: SplashActivity)
    fun inject(activity: MainActivity)
}