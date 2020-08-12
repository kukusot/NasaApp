package com.ikukushev.nasaapp.pictures.apod

import com.ikukushev.nasaapp.data.NasaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ApodModule {

    @Singleton
    @Provides
    fun provideApodRepository(api: NasaApi): ApodRepository = ApodRepository(api)
}