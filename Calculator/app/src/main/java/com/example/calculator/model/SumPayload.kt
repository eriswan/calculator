package com.example.calculator.model

import com.google.gson.annotations.SerializedName

data class SumPayload (

    @SerializedName("a")
    val firstNumber: Float,

    @SerializedName("b")
    val secondNumber: Float
)