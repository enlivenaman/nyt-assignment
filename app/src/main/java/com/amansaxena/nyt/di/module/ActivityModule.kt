package com.amansaxena.nyt.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.amansaxena.nyt.data.repository.NytApiRepository
import com.amansaxena.nyt.ui.TopStoryAdapter
import com.amansaxena.nyt.ui.base.BaseActivity
import com.amansaxena.nyt.ui.splash.SplashViewModel
import com.amansaxena.nyt.util.ViewModelProviderFactory
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import com.amansaxena.nyt.viewmodel.AppViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Kotlin Generics Reference: https://kotlinlang.org/docs/reference/generics.html
 * Basically it means that we can pass any class that extends BaseActivity which take
 * BaseViewModel subclass as parameter
 */
@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(activity)

    @Provides
    fun provideSplashViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper
    ): SplashViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(SplashViewModel::class) {
            SplashViewModel(schedulerProvider, compositeDisposable, networkHelper)
            //this lambda creates and return SplashViewModel
        }).get(SplashViewModel::class.java)


    @Provides
    fun provideAppViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        nytApiRepository: NytApiRepository
    ): AppViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(AppViewModel::class) {
            AppViewModel(schedulerProvider, compositeDisposable, networkHelper, nytApiRepository)
        }).get(AppViewModel::class.java)

    @Provides
    fun provideTopStoryAdapter() = TopStoryAdapter(activity.lifecycle, ArrayList())
}