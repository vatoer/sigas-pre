package com.starganteknologi.sigas.repository

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.starganteknologi.sigas.service.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepo(val loginView: LoginView, private val loginService: LoginService, private  val networkService: NetworkService) {
    fun login(username: String, password: String?) {
// 3
        //val
        val loginRequest = LoginRequest(username,password);

        val loginCall = loginService.login(loginRequest) // 4
        Log.i("loginCall",loginRequest.toString())
        loginCall.enqueue(object : Callback<LoginResponse> {
            // 5
            override fun onFailure(call: Call<LoginResponse>?,
                                   t: Throwable?) {
// 6
                Log.i("tag", t?.message);
            }
            // 7
            override fun onResponse(
                call: Call<LoginResponse>?,
                response: Response<LoginResponse>?) {
// 8
                if (response != null) {
                    val body = response.body() //
                    Log.i("body",body.toString())
                    if(response.isSuccessful){
                        val jwtToken = body?.token.toString()
                        val user = body?.user
                        val userId = user?.id
                        Log.i("response",jwtToken)
                        //updateFcm(userId, token, fcmToken)
                        loginView.onSuccessLogin(userId, jwtToken,"berhasil")
                    }else{

                        Log.i("response",response.toString())
                        Log.i("errorBody",response.errorBody().toString())
                        loginView.onFailedLogin(response.code().toString())
                    }
                }

            } })
    }
}