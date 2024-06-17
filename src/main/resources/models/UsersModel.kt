package models

import java.time.Instant

data class UsersModel(
    val userID: Int,
    val login: String,
    val passwordHash: String,
    val registrationDate: Instant
)