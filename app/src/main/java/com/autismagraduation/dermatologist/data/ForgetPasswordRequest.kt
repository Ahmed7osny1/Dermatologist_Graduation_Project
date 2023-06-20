package com.autismagraduation.dermatologist.data

data class ForgetPasswordRequest(
    val email: String,
    val new_password: String
)
