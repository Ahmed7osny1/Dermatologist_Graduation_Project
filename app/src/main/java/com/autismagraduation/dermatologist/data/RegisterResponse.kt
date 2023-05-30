package com.autismagraduation.dermatologist.data

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String
)