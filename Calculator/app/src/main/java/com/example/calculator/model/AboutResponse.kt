package com.example.calculator.model

import com.google.gson.annotations.SerializedName

data class AboutResponse(

    @SerializedName ("about")
    val about: String?,

    @SerializedName ("version")
    val version: String?
)

data class AboutModel (
    val about: String,
    val version: String
)