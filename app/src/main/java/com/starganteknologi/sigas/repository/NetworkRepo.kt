package com.starganteknologi.sigas.repository

import android.util.Log
import com.starganteknologi.sigas.service.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkRepo(val loginView: LoginView, private val networkService: NetworkService) {

    fun updateFcm(userId: Int?, jwtToken: String?, fcmToken: String?){
        val fcmUpdateRequest = FcmUpdateRequest(fcmToken)
        //val withBearer
        val fcmUpdateCall = networkService.fcmUpdate(fcmUpdateRequest,userId, "Bearer $jwtToken")
        fcmUpdateCall.enqueue(object : Callback<UsersResponse>{
            override fun onFailure(call: Call<UsersResponse>?,
                                   t: Throwable?) {
                Log.i("tag", t?.message);
            }
            override fun onResponse(
                call: Call<UsersResponse>?,
                response: Response<UsersResponse>?) {
                if (response != null) {
                    val body = response.body() //
                    if(response.isSuccessful){
                        Log.i("body successful",body.toString())
                    }else{
                        Log.i("response",response.toString())
                        Log.i("errorBody",response.errorBody().toString())
                        //loginView.onFailedLogin(response.code().toString())
                    }
                }
            }
        })
    }
}