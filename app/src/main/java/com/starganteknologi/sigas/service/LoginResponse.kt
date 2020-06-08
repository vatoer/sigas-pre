package com.starganteknologi.sigas.service

import com.beust.klaxon.Json

data class LoginResponse(
    val token: String?,
    val code: Int?,
    val message: String?,
    val user: User?
)

data class User (
    val id: Int,
    @Json(name = "fcm_token")
    val fcmToken: Any? = null,
    val roles: List<String>
)

