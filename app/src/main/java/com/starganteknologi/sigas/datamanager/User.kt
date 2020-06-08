package com.starganteknologi.sigas.datamanager

data class User (
    val id: Int,
    val email: String?,
    val roles: List<String>?,
    val fullName: String?,
    val displayName: String?,
    //val role: Int,
    val username: String?,
    val plainPassword: String?,
    val fcmToken: String?,
    val jwtToken: String?
)
