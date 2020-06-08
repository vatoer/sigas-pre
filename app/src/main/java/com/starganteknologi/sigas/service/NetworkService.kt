package com.starganteknologi.sigas.service

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

//import retrofit2.http.*

interface NetworkService {

    @Headers(
        "Content-Type: application/merge-patch+json",
        "Accept: application/json"
    )
    @PATCH("api/users/{id}")
    fun fcmUpdate(@Body body: FcmUpdateRequest, @Path("id") id: Int?, @Header("Authorization") jwtToken: String? ) : Call<UsersResponse>

    companion object {
        val instance: NetworkService by lazy {

            val client = OkHttpClient.Builder()
                .addInterceptor(ServiceInterceptor())
                .connectTimeout(20,TimeUnit.SECONDS).build()

            // 5
            val retrofit = Retrofit.Builder()
                .baseUrl("https://sigas-api.starganteknologi.com/")
                //.client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create<NetworkService>(NetworkService::class.java) }
    } }