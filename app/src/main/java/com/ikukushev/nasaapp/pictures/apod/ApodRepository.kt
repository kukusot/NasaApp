package com.ikukushev.nasaapp.pictures.apod

import com.ikukushev.nasaapp.data.NasaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

data class ApodRepository(private val api: NasaApi) {

    suspend fun getLastApod() = withContext(Dispatchers.IO) {
        api.getApod()
    }
}