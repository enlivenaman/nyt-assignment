package com.amansaxena.nyt.ui.splash

import androidx.lifecycle.MutableLiveData
import com.amansaxena.nyt.ui.base.BaseViewModel
import com.amansaxena.nyt.util.common.Event
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class SplashViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    // Event is used by the view model to tell the activity to launch another Activity
    // view model also provided the Bundle in the event that is needed for the Activity
    val launchDummy: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    override fun onCreate() {
        // Empty Bundle passed to Activity in Event that is needed by the other Activity
        // Here in actual application we will decide which screen to open based on
        // either the user is logged in or not
        launchDummy.postValue(Event(emptyMap()))
    }
}