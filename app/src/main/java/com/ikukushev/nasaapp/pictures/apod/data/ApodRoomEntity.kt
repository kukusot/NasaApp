package com.ikukushev.nasaapp.pictures.apod.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apod")
data class ApodRoomEntity(
    @PrimaryKey @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "hdUrl") val hdUrl: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "explanation") val explanation: String,
    @ColumnInfo(name = "title") val title: String
)