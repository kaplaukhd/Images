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
import com.kaplaukhd.images.model.Result
import com.kaplaukhd.images.ui.viewModels.MainViewModel
import javax.inject.Inject

private val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent
    }


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        model = ViewModelProvider(this, factory)[MainViewModel::class.java]
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.setHasFixedSize(true)

        model.data.observe(this) {
            when (it) {
                is Result.Success -> {
                    recycler.adapter = ImageAdapter(this@MainActivity, it.data!!)
                }
                else -> {
                    Toast.makeText(this, it.message.toString(), Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}
