package com.example.calculator.service

import com.example.calculator.model.SumModel
import com.example.calculator.model.SumPayload
import com.example.calculator.model.SumResponse
import com.example.calculator.networking.WidgetProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SumService(
    private val successCallback: (SumModel) -> Unit,
    private val failureCallback: (Throwable) -> Unit
) : Callback<SumResponse> {

    fun sum(firstNumber: String?, secondNumber: String?) {
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
        val sumPayload = SumPayload(first, second)
        WidgetProvider.provide().sum(sumPayload).enqueue(this)
    }

    override fun onFailure(call: Call<SumResponse>, t: Throwable) {
        failureCallback(t)
    }

    override fun onResponse(call: Call<SumResponse>, response: Response<SumResponse>) {
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

        val sumModel = SumModel(resultNumber)
        successCallback(sumModel)
    }
}