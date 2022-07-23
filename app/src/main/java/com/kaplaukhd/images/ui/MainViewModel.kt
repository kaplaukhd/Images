package com.kaplaukhd.images.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kaplaukhd.images.BaseRepository
import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.data.ImagesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(repository: ImagesRepository) : ViewModel() {

    init {
        CoroutineScope(Dispatchers.IO).launch {
        }
    }

    private val _data = MutableLiveData<ArrayList<ImagesApi>>()
    val data: LiveData<ArrayList<ImagesApi>>
        get() = _data

}



