package com.autismagraduation.pharmacy.interfaces

import com.autismagraduation.pharmacy.data.*
import com.autismagraduation.pharmacy.`object`.Constants
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.Register_URL)
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>

    @PUT(Constants.Forget_URL)
    fun forgetPassword(@Body request: ForgetPasswordRequest): Call<ForgetPasswordResponse>

    /*@GET(Constants.Profile_URL)
    fun getUserProfile(@Header("Authorization") token: String): Call<UserProfile>

    @GET(Constants.Medicine_URL)
    fun getMedicine(): Call<MedicineDataX>

    @GET(Constants.Offer_URL)
    fun getOffer(): Call<MedicineDataX>*/
}