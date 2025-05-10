package com.example.simplevpn

data class ServerConfig(
    val host: String,
    val port: Int,
    val password: String,
    val protocol: String
)
