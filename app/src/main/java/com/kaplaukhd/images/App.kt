package com.kaplaukhd.images

import android.app.Application
import com.kaplaukhd.images.data.AppComponent
import com.kaplaukhd.images.data.DaggerAppComponent

class App: Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}