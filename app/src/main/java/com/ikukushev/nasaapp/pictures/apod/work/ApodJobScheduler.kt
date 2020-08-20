package com.ikukushev.nasaapp.pictures.apod.work

import android.content.Context
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val APOD_TAG = "apod"

class ApodJobScheduler @Inject constructor(@ApplicationContext private val context: Context) {

    fun scheduleApod() {
        with(WorkManager.getInstance(context)) {
            cancelAllWorkByTag(APOD_TAG)
            enqueue(
                PeriodicWorkRequestBuilder<FetchApodWorker>(1, TimeUnit.DAYS)
                    .addTag(APOD_TAG)
                    .build()
            )
        }
    }
}