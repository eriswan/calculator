package com.example.calculator.model

import com.google.gson.annotations.SerializedName

data class SumResponse (
    @SerializedName ("sum")
    val resultNumber: Float?
)

data class SumModel (
    val resultNumber: Float
)