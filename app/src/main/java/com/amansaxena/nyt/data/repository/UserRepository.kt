package com.amansaxena.nyt.data.repository

import com.amansaxena.nyt.data.local.db.DatabaseService
import com.amansaxena.nyt.data.local.prefs.UserPreferences
import com.amansaxena.nyt.data.model.User
import com.amansaxena.nyt.data.remote.NetworkService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService,
    private val userPreferences: UserPreferences
) {

    fun saveCurrentUser(user: User) {
        userPreferences.setUserId(user.id)
        userPreferences.setUserName(user.name)
        userPreferences.setUserEmail(user.email)
        userPreferences.setAccessToken(user.accessToken)
    }

    fun removeCurrentUser() {
        userPreferences.removeUserId()
        userPreferences.removeUserName()
        userPreferences.removeUserEmail()
        userPreferences.removeAccessToken()
    }

    fun getCurrentUser(): User? {

        val userId = userPreferences.getUserId()
        val userName = userPreferences.getUserName()
        val userEmail = userPreferences.getUserEmail()
        val accessToken = userPreferences.getAccessToken()

        return if (userId !== null && userName != null && userEmail != null && accessToken != null)
            User(userId, userName, userEmail, accessToken)
        else
            null
    }
}