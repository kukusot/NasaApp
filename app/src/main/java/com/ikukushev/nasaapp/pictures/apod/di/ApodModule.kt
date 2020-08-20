package com.ikukushev.nasaapp.pictures.apod.di

import android.content.Context
import androidx.room.Room
import com.ikukushev.nasaapp.pictures.apod.db.ApodDao
import com.ikukushev.nasaapp.pictures.apod.db.ApodDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class ApodModule {

    @Singleton
    @Provides
    fun provideApodDatabase(@ApplicationContext context: Context): ApodDatabase =
        Room.databaseBuilder(context, ApodDatabase::class.java, "apod.db").build()

    @Singleton
    @Provides
    fun provideApodDao(database: ApodDatabase): ApodDao = database.apodDao()

}