package com.example.calculator.networking

import com.example.calculator.model.SubPayload
import com.example.calculator.model.SubResponse
import com.example.calculator.model.SumPayload
import com.example.calculator.model.SumResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Widget {
    @POST("widgets/sum")
    fun sum(
        @Body sumPayload: SumPayload
    ): Call<SumResponse>

    @POST("widgets/sub")
    fun sub(
        @Body subPayload: SubPayload
    ): Call<SubResponse>
}