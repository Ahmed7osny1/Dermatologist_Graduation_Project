package com.autismagraduation.dermatologist.interfaces

import com.autismagraduation.dermatologist.data.LoginRequest
import com.autismagraduation.dermatologist.data.LoginResponse
import com.autismagraduation.dermatologist.data.RegisterResponse
import com.autismagraduation.dermatologist.data.UserData
import com.autismagraduation.dermatologist.`object`.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.Register_URL)
    fun register(@Body request: UserData): Call<RegisterResponse>
}