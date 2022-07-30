package com.kaplaukhd.images.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.data.repositoroy.ImagesRepository
import com.kaplaukhd.images.api.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(private var repository: ImagesRepository) : ViewModel() {
    private var _data = MutableLiveData<Result<ArrayList<ImagesApi>>>()
    val data: LiveData<Result<ArrayList<ImagesApi>>>
        get() = _data

    init {
        getData()
    }

    private fun getData() = viewModelScope.launch(Dispatchers.IO) {
        _data.postValue(repository.getImages())
    }

}



