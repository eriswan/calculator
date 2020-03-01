package com.example.calculator.networking

import com.example.calculator.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
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

    @POST("widgets/div")
    fun div(
        @Body divPayload: DivPayload
    ): Call<DivResponse>

    @POST("widgets/mult")
    fun mult(
        @Body multPayload: MultPayload
    ): Call<MultResponse>

    @GET ("widgets/about")
    fun about(): Call<AboutResponse>
}
