package com.jeancorzo.rickandmorty.session

import com.jeancorzo.rickandmorty.storage.PreferenceDataStoreApi
import com.jeancorzo.rickandmorty.storage.PreferenceDataStoreConstants
import kotlinx.coroutines.delay

class LocalSessionManager(private val preferenceDataStoreApi: PreferenceDataStoreApi) : SessionManager {

    override suspend fun isLoggedIn(): Boolean {
        return preferenceDataStoreApi.getFirstPreference(PreferenceDataStoreConstants.IS_LOGGED_IN, false)
    }

    override suspend fun logIn() {
        delay(1000)
        preferenceDataStoreApi.putPreference(PreferenceDataStoreConstants.IS_LOGGED_IN, true)
    }
}