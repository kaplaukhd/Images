package com.kaplaukhd.images.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.kaplaukhd.images.App
import com.kaplaukhd.images.R
import com.kaplaukhd.images.data.AppComponent
import com.kaplaukhd.images.data.ImagesRepository
import com.kaplaukhd.images.data.Result
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
        appComponent.inject(this)
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.setHasFixedSize(true)
        CoroutineScope(Dispatchers.IO).launch {
        }

        model.data.observe(this){
            when(it){
                is Result.Error -> recycler.adapter = ImageAdapter(this@MainActivity, it.data!!)
                is Result.Success -> Toast.makeText(this, it.message.toString(), Toast.LENGTH_LONG).show()
            }

        }
    }
}
