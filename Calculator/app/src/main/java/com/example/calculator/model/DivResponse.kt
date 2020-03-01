package com.example.calculator.model

import com.google.gson.annotations.SerializedName

data class DivResponse (

    @SerializedName ("div")
    val resultNumber: Float?
)

data class DivModel (
    val resultNumber: Float
)