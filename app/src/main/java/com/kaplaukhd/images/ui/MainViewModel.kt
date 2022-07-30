package com.kaplaukhd.images.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.data.ImagesRepository
import com.kaplaukhd.images.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ImagesRepository) : ViewModel() {
    private var _data = MutableLiveData<Result<ArrayList<ImagesApi>>>()
    val data: LiveData<Result<ArrayList<ImagesApi>>>
        get() = _data

    init {
        data
    }

    private fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _data = repository.getImages()
    }

}



