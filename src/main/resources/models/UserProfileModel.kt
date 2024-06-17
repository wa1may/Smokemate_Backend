package models

import java.time.LocalDate

data class UserProfileModel(
    val userID: Int,
    val firstName: String,
    val lastName: String,
    val birthday: LocalDate,
    val email: String,
    val phoneNumber: String,
    val country: String,
    val city: String,
    val favoriteCigarettes: String,
    val profileDescription: String,
    val profilePhotoURL: String
)