package com.amansaxena.nyt.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.amansaxena.nyt.MainApplication
import com.amansaxena.nyt.data.local.db.DatabaseService
import com.amansaxena.nyt.data.remote.NetworkService
import com.amansaxena.nyt.di.ApplicationContext
import com.amansaxena.nyt.di.module.ApplicationModule
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: MainApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    /**
     * These methods are written in ApplicationComponent because the instance of
     * NetworkService is singleton and is maintained in the ApplicationComponent's implementation by Dagger
     * For NetworkService singleton instance to be accessible to say DummyActivity's DummyViewModel
     * this ApplicationComponent must expose a method that returns NetworkService instance
     * This method will be called when NetworkService is injected in DummyViewModel.
     * Also, in ActivityComponent you can find dependencies = [ApplicationComponent::class] to link this relationship
     */
    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getSharedPreferences(): SharedPreferences

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable
}