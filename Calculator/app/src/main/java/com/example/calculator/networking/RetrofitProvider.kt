package com.example.calculator.networking

import com.example.calculator.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {
    fun provide(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkhttpProvider.provide())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
}