package com.kaplaukhd.images.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.data.ImagesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ImagesRepository) : ViewModel() {

    init {
        getImages()
    }

    private val _data = MutableLiveData<ArrayList<ImagesApi>>()
    val data: LiveData<ArrayList<ImagesApi>>
        get() = _data

   private fun getImages() = viewModelScope.launch(Dispatchers.IO) {

    }

}



