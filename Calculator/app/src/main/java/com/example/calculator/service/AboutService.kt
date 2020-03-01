package com.example.calculator.service

import com.example.calculator.model.*
import com.example.calculator.networking.WidgetProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutService(
    private val successCallback: (AboutModel) -> Unit,
    private val failureCallback: (Throwable) -> Unit
) : Callback<AboutResponse> {

    fun about() {
        WidgetProvider.provide().about().enqueue(this)
    }

    override fun onFailure(call: Call<AboutResponse>, t: Throwable) {
        failureCallback(t)
    }

    override fun onResponse(call: Call<AboutResponse>, response: Response<AboutResponse>) {
        val body = response.body()

        if (body == null) {
            failureCallback(Exception("Failed to read the body"))
            return
        }

        val about = body.about
        if (about == null) {
            failureCallback(Exception("About is null"))
            return
        }

        val version = body.version
        if (version == null) {
            failureCallback(java.lang.Exception("Version is null"))
            return
        }

        val aboutModel = AboutModel(about, version)
        successCallback(aboutModel)
    }
}
