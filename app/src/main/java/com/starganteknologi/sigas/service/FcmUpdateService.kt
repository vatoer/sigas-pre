package com.starganteknologi.sigas.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface FcmUpdateService {

    @Headers(
            "Content-Type: application/merge-patch+json",
            "Accept: application/json",
            "User-Agent: Sigas"
    )
    @POST("api/users/{id}")
    fun register(@Body body: LoginRequest ) : Call<LoginResponse>

    companion object {
        // 4
        val instance: FcmUpdateService by lazy {
            // 5
            val retrofit = Retrofit.Builder() .baseUrl("https://sigas-api.starganteknologi.com/") .addConverterFactory(
                GsonConverterFactory.create()) .build()
// 6
            retrofit.create<FcmUpdateService>(FcmUpdateService::class.java) }
    } }