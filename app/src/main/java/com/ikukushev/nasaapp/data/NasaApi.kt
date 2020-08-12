package com.ikukushev.nasaapp.data

import com.ikukushev.nasaapp.pictures.apod.data.Apod
import retrofit2.http.GET

interface NasaApi {

    @GET("planetary/apod?api_key=DEMO_KEY")
    suspend fun getApod(): Apod

}