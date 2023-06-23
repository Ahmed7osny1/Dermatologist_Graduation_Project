package com.autismagraduation.pharmacy.data

import okhttp3.MultipartBody

data class RegisterRequest(
    val name: String,
    val email: String,
    val password: String,
    val phone_number: String,
    val location: String,
    val description: String,
    //val pharmacy_image: MultipartBody.Part?
)