package com.example.calculator.model

import com.google.gson.annotations.SerializedName

data class SubResponse (
    @SerializedName ("sub")
    val resultNumber: Float?
)

data class SubModel (
    val resultNumber: Float
)