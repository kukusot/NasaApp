package com.ikukushev.nasaapp.pictures.apod.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ikukushev.nasaapp.pictures.apod.data.ApodRoomEntity

@Database(entities = [ApodRoomEntity::class], version = 1)
@TypeConverters(ApodDatabaseTypeConverter::class)
abstract class ApodDatabase : RoomDatabase() {

    abstract fun apodDao(): ApodDao
}