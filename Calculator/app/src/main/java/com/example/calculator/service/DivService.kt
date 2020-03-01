package com.example.calculator.service

import com.example.calculator.model.*
import com.example.calculator.networking.WidgetProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DivService(
    private val successCallback: (DivModel) -> Unit,
    private val failureCallback: (Throwable) -> Unit
) : Callback<DivResponse> {

    fun div(firstNumber: String?, secondNumber: String?) {
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
        val divPayload = DivPayload(first, second)
        WidgetProvider.provide().div(divPayload).enqueue(this)
    }

    override fun onFailure(call: Call<DivResponse>, t: Throwable) {
        failureCallback(t)
    }

    override fun onResponse(call: Call<DivResponse>, response: Response<DivResponse>) {
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

        val divModel = DivModel(resultNumber)
        successCallback(divModel)
    }
}