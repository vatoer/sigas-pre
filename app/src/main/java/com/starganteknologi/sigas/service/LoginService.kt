package com.starganteknologi.sigas.service

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

//import retrofit2.http.*

interface LoginService {

    @Headers(
        "Content-Type: application/json"
    )
    @POST("api/login_check")
    fun login(@Body body: LoginRequest ) : Call<LoginResponse>

    companion object {
        // 4

        val instance: LoginService by lazy {
            // 5
            val retrofit = Retrofit.Builder()
                .baseUrl("https://sigas-api.starganteknologi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

// 6
            retrofit.create<LoginService>(LoginService::class.java) }
    } }