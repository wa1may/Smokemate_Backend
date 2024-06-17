package models

import java.time.Instant

data class MessageModel(
    val messageID: Int,
    val senderID: Int,
    val receiverID: Int,
    val messageText: String,
    val sendDateTime: Instant
)