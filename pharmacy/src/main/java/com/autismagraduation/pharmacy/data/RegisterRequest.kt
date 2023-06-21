package com.autismagraduation.pharmacy.data

import okhttp3.MultipartBody

data class RegisterRequest(
    val description: String,
    val email: String,
    val location: String,
    val name: String,
    val password: String,
    val pharmacy_image: MultipartBody.Part,
    val phone_number: String
)