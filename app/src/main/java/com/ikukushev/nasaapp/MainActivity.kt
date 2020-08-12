package com.ikukushev.nasaapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ikukushev.nasaapp.pictures.apod.ApodFragment
import com.ikukushev.nasaapp.pictures.apod.ApodViewModel
import com.ikukushev.nasaapp.pictures.apod.db.ApodDatabase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}