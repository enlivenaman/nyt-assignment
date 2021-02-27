package com.amansaxena.nyt.viewmodel

import androidx.lifecycle.ViewModel
import com.amansaxena.nyt.ui.base.BaseViewModel
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class AppViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {
        // do something
    }
}