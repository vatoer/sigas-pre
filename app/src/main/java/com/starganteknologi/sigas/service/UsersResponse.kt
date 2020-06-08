package com.starganteknologi.sigas.service

import com.beust.klaxon.Json
data class UsersResponse (
    @Json(name = "@context")
    val context: String,

    @Json(name = "@id")
    val id: String?,

    @Json(name = "@type")
    val type: String,

    @Json(name = "hydra:title")
    val hydraTitle: String?,

    @Json(name = "hydra:description")
    val hydraDescription: String?,


    @Json(name = "id")
    val usersID: Int,

    val email: String?,
    val roles: List<String>?,
    val fullName: String?,
    val displayName: String?,
    val role: Int?,
    val username: String?,
    val fcmToken: String?
)
