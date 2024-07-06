package com.example.finalpizzashift2024.net.data

import com.example.finalpizzashift2024.net.PizzaService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer{
    val pizzaRepository: PizzaRepository
}

class DefaultAppContainer: AppContainer {
    private val BASE_URL = "https://shift-backend.onrender.com/pizza/"

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(createLoggingInterceptor())
            .build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    private var retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build();

    private val retrofitService: PizzaService by lazy{
        retrofit.create(PizzaService::class.java)
    }

    override val pizzaRepository: PizzaRepository by lazy {
        NetPizzaRepository(retrofitService)
    }

}