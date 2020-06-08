package com.starganteknologi.sigas.service

import com.beust.klaxon.Json

data class LoginSuccessResponse (
    val token: String,
    val user: User
)
