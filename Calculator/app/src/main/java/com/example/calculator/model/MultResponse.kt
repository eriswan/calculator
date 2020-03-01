package com.example.calculator.model

import com.google.gson.annotations.SerializedName

data class MultResponse (
    @SerializedName ("mult")
    val resultNumber: Float?
)

data class MultModel (
    val resultNumber: Float
)