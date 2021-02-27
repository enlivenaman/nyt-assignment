package com.amansaxena.nyt.data.repository

import com.amansaxena.nyt.data.local.db.DatabaseService
import com.amansaxena.nyt.data.model.Dummy
import com.amansaxena.nyt.data.remote.NetworkService
import com.amansaxena.nyt.data.remote.request.DummyRequest
import com.amansaxena.nyt.data.remote.response.TopStoryModel
import com.amansaxena.nyt.data.remote.response.TopStoryModelResponse
import io.reactivex.Single
import javax.inject.Inject

class NytApiRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchTopStories(id: String): Single<List<TopStoryModel>> =
        networkService.doTopStoryCall(id).map { it.results }
}