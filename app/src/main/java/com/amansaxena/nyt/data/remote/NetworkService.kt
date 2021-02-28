package com.amansaxena.nyt.data.remote

import com.amansaxena.nyt.data.remote.response.TopStoryModelResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.TOPSTORY)
    fun doTopStoryCall(
        @Path("section") section: String,
        @Query("api-key") apikey: String
    ): Single<TopStoryModelResponse>
}