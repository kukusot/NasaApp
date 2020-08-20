package com.ikukushev.nasaapp.pictures.apod.work

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.ikukushev.nasaapp.data.NasaApi
import com.ikukushev.nasaapp.pictures.apod.data.ApodRoomEntity
import com.ikukushev.nasaapp.pictures.apod.db.ApodDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchApodWorker @WorkerInject constructor(
    @Assisted context: Context,
    @Assisted workerParameters: WorkerParameters,
    private val apodDao: ApodDao,
    private val api: NasaApi
) : CoroutineWorker(context, workerParameters) {


    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val response = api.getApod()
            Log.e("XXX","apod network "+response)
            apodDao.insertApod(
                ApodRoomEntity(
                    url = response.url,
                    date = response.date,
                    hdUrl = response.hdUrl,
                    explanation = response.explanation,
                    title = response.title
                )
            )
            return@withContext Result.success()
        } catch (e: Throwable) {
            Log.e("FetchApodWorker", e.message, e)
            Result.failure()
        }
    }
}