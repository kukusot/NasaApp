package com.ikukushev.nasaapp.pictures.apod

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikukushev.nasaapp.core.data.Result
import com.ikukushev.nasaapp.pictures.apod.data.Apod
import com.ikukushev.nasaapp.pictures.apod.data.ApodRoomEntity
import com.ikukushev.nasaapp.pictures.apod.db.ApodDatabase
import kotlinx.coroutines.launch


class ApodViewModel @ViewModelInject constructor(
    private val apodRepository: ApodRepository,
    private val db: ApodDatabase
) :
    ViewModel() {

    private val _apodData = MutableLiveData<Result<Apod>>()
    val apodData: LiveData<Result<Apod>> = _apodData

    init {
        viewModelScope.launch {
            val result = apodRepository.getLastApod()
            _apodData.value = Result.Success(result)

            val apods = db.apodDao().getAll()
            Log.e("XXX", "apods size  " + apods.size)

            db.apodDao().insertApod(
                ApodRoomEntity(
                    date = result.date,
                    explanation = result.explanation,
                    url = result.url,
                    hdUrl = result.hdUrl,
                    title = result.title
                )
            )
        }
    }
}