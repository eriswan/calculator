package com.example.calculator.networking

import com.example.calculator.BuildConfig
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkhttpProvider {
    fun provide(): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(BuildConfig.TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(BuildConfig.TIMEOUT, TimeUnit.MILLISECONDS)
            .readTimeout(BuildConfig.TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(BuildConfig.TIMEOUT, TimeUnit.MILLISECONDS)
            .build()
    }
}