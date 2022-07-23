package com.kaplaukhd.images.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.kaplaukhd.images.App
import com.kaplaukhd.images.ImageAdapter
import com.kaplaukhd.images.R
import com.kaplaukhd.images.api.ImagesApi
import com.kaplaukhd.images.data.AppComponent
import com.kaplaukhd.images.data.ImagesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }

class MainActivity : AppCompatActivity() {
    private val model by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(model)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.setHasFixedSize(true)
        model.data.observe(this){
            recycler.adapter = ImageAdapter(this@MainActivity, it)
        }
    }
}
