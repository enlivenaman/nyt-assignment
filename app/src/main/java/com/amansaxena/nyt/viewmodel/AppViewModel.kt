package com.amansaxena.nyt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.amansaxena.nyt.data.remote.response.TopStoryModel
import com.amansaxena.nyt.data.repository.NytApiRepository
import com.amansaxena.nyt.ui.base.BaseViewModel
import com.amansaxena.nyt.util.common.Resource
import com.amansaxena.nyt.util.network.NetworkHelper
import com.amansaxena.nyt.util.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class AppViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val nytApiRepository: NytApiRepository
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    private val topStoryLiveData: MutableLiveData<Resource<List<TopStoryModel>>> = MutableLiveData()

    fun getTopStories(): LiveData<List<TopStoryModel>> =
        Transformations.map(topStoryLiveData) { it.data }

    override fun onCreate() {
        //subscribe to top stories
        if (topStoryLiveData.value == null && checkInternetConnectionWithMessage()) {
            topStoryLiveData.postValue(Resource.loading())
            compositeDisposable.add(
                nytApiRepository.fetchTopStories("art")
                    .subscribeOn(schedulerProvider.io())
                    .subscribe(
                        { topStoryLiveData.postValue(Resource.success(it)) },
                        {
                            handleNetworkError(it)
                            topStoryLiveData.postValue(Resource.error())
                        })
            )
        }
    }
}