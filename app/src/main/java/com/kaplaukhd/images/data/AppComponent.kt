package com.kaplaukhd.images.data

import androidx.lifecycle.ViewModelProvider
import com.kaplaukhd.images.data.repositoroy.ImagesRepository
import com.kaplaukhd.images.ui.MainActivity
import com.kaplaukhd.images.ui.ViewModelFactory
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Component(modules = [AppModule::class, ViewModel::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}

@Module
object AppModule {
    @Provides
    fun provideRetrofit(): RetrofitServices {
        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
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

@Module
abstract class ViewModel{
    @Binds
    abstract fun bindsViewModelFactory(f: ViewModelFactory): ViewModelProvider.Factory
}