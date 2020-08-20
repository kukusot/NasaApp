package com.ikukushev.nasaapp.pictures.apod

import com.ikukushev.nasaapp.data.NasaApi
import com.ikukushev.nasaapp.pictures.apod.db.ApodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

data class ApodRepository @Inject constructor(
    private val api: NasaApi,
    private val apodDao: ApodDao
) {

    suspend fun getLastApod() = withContext(Dispatchers.IO) {
        api.getApod()
    }

    suspend fun getPreviousApods() = withContext(Dispatchers.IO) {
        apodDao.getAll()
    }
}