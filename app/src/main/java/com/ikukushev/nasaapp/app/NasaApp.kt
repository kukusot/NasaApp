package com.ikukushev.nasaapp.app

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.ikukushev.nasaapp.pictures.apod.work.ApodJobScheduler
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class NasaApp : Application(), Configuration.Provider {

    override fun onCreate() {
        super.onCreate()
        sd.scheduleApod()
    }

    @Inject
    lateinit var workerFactory: HiltWorkerFactory
    @Inject
    lateinit var sd : ApodJobScheduler

    override fun getWorkManagerConfiguration() =
        Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
}
