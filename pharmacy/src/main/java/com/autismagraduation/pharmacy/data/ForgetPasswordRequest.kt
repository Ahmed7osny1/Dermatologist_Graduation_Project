package com.autismagraduation.pharmacy.data

data class ForgetPasswordRequest(
    val email: String,
    val new_password: String
)
