package com.example.calculator.service

import com.example.calculator.model.*
import com.example.calculator.networking.WidgetProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubService(
    private val successCallback: (SubModel) -> Unit,
    private val failureCallback: (Throwable) -> Unit
) : Callback<SubResponse> {

    fun sub(firstNumber: String?, secondNumber: String?) {
        val first: Float? = firstNumber?.toFloatOrNull()
        if (first == null){
            failureCallback(Exception("First number is not a valid number"))
            return
        }
        val second: Float? = secondNumber?.toFloatOrNull()
        if (second == null){
            failureCallback(Exception("Second number is not a valid number"))
            return
        }
        val subPayload = SubPayload(first, second)
        WidgetProvider.provide().sub(subPayload).enqueue(this)
    }

    override fun onFailure(call: Call<SubResponse>, t: Throwable) {
        failureCallback(t)
    }

    override fun onResponse(call: Call<SubResponse>, response: Response<SubResponse>) {
        val body = response.body()

        if (body == null) {
            failureCallback(Exception("Failed to read the body"))
            return
        }

        val resultNumber = body.resultNumber
        if (resultNumber == null) {
            failureCallback(Exception("Result number is null"))
            return
        }

        val subModel = SubModel(resultNumber)
        successCallback(subModel)
    }
}