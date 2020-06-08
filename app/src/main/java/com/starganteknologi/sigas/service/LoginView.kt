package com.starganteknologi.sigas.service

interface LoginView {
    fun onSuccessLogin (userId: Int?, jwtToken : String?,msg : String?)
    fun onFailedLogin (msg : String?)
}