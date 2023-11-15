package com.islas.codechallengenov.data.utils

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object ClientHttp {
    const val BASE_URL = "https://gateway.marvel.com"
    const val API_KEY = "c35b6c18bc0a6fbef44371d3513e7700"
    private const val PRIVATE_KEY = "2fa1d6879f33d51b1d0b77631115cc4c46f8d33b"
    const val LIMIT = "50"
    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
    fun hash(): String {
        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}