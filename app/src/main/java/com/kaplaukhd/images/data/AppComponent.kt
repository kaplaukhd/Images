package com.kaplaukhd.images.data

import androidx.lifecycle.ViewModel
import com.kaplaukhd.images.ui.MainActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
}

@Module
object AppModule {

    @Provides
    fun provideRetrofit(): RetrofitServices {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(RetrofitServices::class.java)
    }

    @Provides
    fun provideRepository(retrofit: RetrofitServices): ImagesRepository {
        return ImagesRepository(retrofit)
    }
}