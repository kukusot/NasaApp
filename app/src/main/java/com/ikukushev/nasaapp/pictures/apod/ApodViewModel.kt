package com.ikukushev.nasaapp.pictures.apod

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ikukushev.nasaapp.core.data.Result
import com.ikukushev.nasaapp.pictures.apod.data.ApodListItem
import kotlinx.coroutines.launch


class ApodViewModel @ViewModelInject constructor(
    private val apodRepository: ApodRepository
) : ViewModel() {

    private val _apodData = MutableLiveData<Result<List<ApodListItem>>>()
    val apodData: LiveData<Result<List<ApodListItem>>> = _apodData

    init {
        viewModelScope.launch {
            val result = apodRepository.getPreviousApods()
            val apodLIstItems = result.map {
                ApodListItem(it.url)
            }
            _apodData.value = Result.Success(apodLIstItems)
        }
    }
}