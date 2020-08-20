package com.ikukushev.nasaapp.pictures.apod.data

import com.google.gson.annotations.SerializedName
import java.util.*

data class Apod(
    @SerializedName("date") val date: Date,
    @SerializedName("explanation") val explanation: String,
    @SerializedName("hdurl") val hdUrl: String,
    @SerializedName("url") val url: String,
    @SerializedName("title") val title: String
)