package models

data class ProfilePhotoModel(
    val photoID: Int,
    val userID: Int,
    val photoURL: String,
    val isMainPhoto: Int
)