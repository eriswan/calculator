package com.example.calculator.service

import com.example.calculator.model.*
import com.example.calculator.networking.WidgetProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MultService(
    private val successCallback: (MultModel) -> Unit,
    private val failureCallback: (Throwable) -> Unit
) : Callback<MultResponse> {

    fun mult(firstNumber: String?, secondNumber: String?) {
        val first: Float? = firstNumber?.toFloatOrNull()
        if (first == null) {
            failureCallback(Exception("First number is not a valid number"))
            return
        }
        val second: Float? = secondNumber?.toFloatOrNull()
        if (second == null) {
            failureCallback(Exception("Second number is not a valid number"))
            return
        }
        val multPayload = MultPayload(first, second)
        WidgetProvider.provide().mult(multPayload).enqueue(this)
    }

    override fun onFailure(call: Call<MultResponse>, t: Throwable) {
        failureCallback(t)
    }

    override fun onResponse(call: Call<MultResponse>, response: Response<MultResponse>) {
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

        val multModel = MultModel(resultNumber)
        successCallback(multModel)
    }
}

