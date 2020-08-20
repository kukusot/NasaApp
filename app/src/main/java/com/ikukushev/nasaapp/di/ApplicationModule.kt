package com.ikukushev.nasaapp.di

import android.content.Context
import androidx.work.WorkManager
import com.google.gson.GsonBuilder
import com.ikukushev.nasaapp.BuildConfig
import com.ikukushev.nasaapp.data.NasaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideApi(): NasaApi {
        val client = OkHttpClient.Builder().apply {
            if (BuildConfig.DEBUG) {
                addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BASIC
                    }
                )
            }
        }.build()

        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/")
            .client(client)
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd").create()
                )
            )
            .build()
            .create(NasaApi::class.java)
    }

    @Provides
    fun provideWorkManager(context: Context) = WorkManager.getInstance(context)

}