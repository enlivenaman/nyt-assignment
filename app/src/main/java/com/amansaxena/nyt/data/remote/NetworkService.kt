package com.amansaxena.nyt.data.remote

import com.amansaxena.nyt.BuildConfig
import com.amansaxena.nyt.data.model.TopStoryModelResponse
import com.amansaxena.nyt.data.remote.request.DummyRequest
import com.amansaxena.nyt.data.remote.response.DummyResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.TOPSTORY)
    fun doTopStoryCall(
        @Path("section") section: String,
        @Path("apikey") apikey: String = Networking.API_KEY
    ): Single<TopStoryModelResponse>
}