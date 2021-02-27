package com.amansaxena.nyt

import android.app.Application
import com.amansaxena.nyt.di.component.ApplicationComponent
import com.amansaxena.nyt.di.component.DaggerApplicationComponent
import com.amansaxena.nyt.di.module.ApplicationModule

class MainApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}