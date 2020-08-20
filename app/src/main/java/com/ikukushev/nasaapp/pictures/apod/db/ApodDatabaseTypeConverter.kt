package com.ikukushev.nasaapp.pictures.apod.db

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

class ApodDatabaseTypeConverter {

    @TypeConverter
    fun dateToString(date: Date): String {
        return ApodDateFormat.format(date)
    }

    @TypeConverter
    fun stringToDate(dateString: String): Date = ApodDateFormat.parse(dateString)!!

    companion object {
        @SuppressLint("SimpleDateFormat")
        val ApodDateFormat = SimpleDateFormat("yyyy-MM-dd")
    }
}