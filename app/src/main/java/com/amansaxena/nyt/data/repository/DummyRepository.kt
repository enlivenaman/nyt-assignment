package com.amansaxena.nyt.data.repository

import com.amansaxena.nyt.data.local.db.DatabaseService
import com.amansaxena.nyt.data.model.Dummy
import com.amansaxena.nyt.data.remote.NetworkService
import com.amansaxena.nyt.data.remote.request.DummyRequest
import io.reactivex.Single
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchDummy(id: String): Single<List<Dummy>> =
        networkService.doDummyCall(DummyRequest(id)).map { it.data }

}