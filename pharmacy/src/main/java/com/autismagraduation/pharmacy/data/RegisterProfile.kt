package com.autismagraduation.pharmacy.data

data class RegisterProfile(
    val name: String,
    val description: String,
    val email: String,
    val location: String,
    val password: String,
    val pharmacy_image: String,
    val phone_number: String
)