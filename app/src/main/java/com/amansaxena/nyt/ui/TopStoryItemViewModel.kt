package com.amansaxena.nyt.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.amansaxena.nyt.data.remote.response.TopStoryModel
import com.amansaxena.nyt.ui.base.BaseItemViewModel
import com.amansaxena.nyt.util.common.Resource
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TopStoryItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseItemViewModel<TopStoryModel>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "DummyItemViewModel"
    }

    val name: LiveData<String> = Transformations.map(data) { it.abstract }
    val url: LiveData<String?> = Transformations.map(data) { it.url }

    fun onItemClick(position: Int) {
        messageString.postValue(Resource.success("onItemClick at $position of ${data.value?.title}"))
        Log.d(TAG, "onItemClick at $position")
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate called")
    }
}