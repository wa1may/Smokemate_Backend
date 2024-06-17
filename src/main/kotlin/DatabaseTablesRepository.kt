import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update
import org.jetbrains.exposed.sql.deleteWhere
import models.UsersModel
import models.UserProfileModel
import models.ProfilePhotoModel
import models.MessageModel
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq

class UserRepository {
    fun createUsers(users: UsersModel) {
        transaction {
            Users.insert {
                it[userID] = users.userID
                it[login] = users.login
                it[passwordHash] = users.passwordHash
                it[registrationDate] = users.registrationDate
            }
        }
    }

    fun getUsersById(userID: Int): UsersModel? {
        return transaction {
            val result = Users.select { Users.userID eq userID }.singleOrNull()

            result?.let {
                UsersModel(
                    it[Users.userID],
                    it[Users.login],
                    it[Users.passwordHash],
                    it[Users.registrationDate]
                )
            }
        }
    }

    fun updateUsers(users: UsersModel) {
        transaction {
            Users.update({ Users.userID eq users.userID }) {
                it[login] = users.login
                it[passwordHash] = users.passwordHash
                it[registrationDate] = users.registrationDate
            }
        }
    }

    fun deleteUsers(userID: Int) {
        transaction {
            Users.deleteWhere { Users.userID eq userID }
        }
    }
}

class UserProfilesRepository {
    fun createUserProfiles(userProfiles: UserProfileModel) {
        transaction {
            UserProfiles.insert {
                it[firstName] = userProfiles.firstName
                it[lastName] = userProfiles.lastName
                it[birthday] = userProfiles.birthday
                it[email] = userProfiles.email
                it[phoneNumber] = userProfiles.phoneNumber
                it[country] = userProfiles.country
                it[city] = userProfiles.city
                it[favoriteCigarettes] = userProfiles.favoriteCigarettes
                it[profileDescription] = userProfiles.profileDescription
                it[profilePhotoURL] = userProfiles.profilePhotoURL
            }
        }
    }

    fun getUserProfilesById(userID: Int): UserProfileModel? {
        return transaction {
            val result = UserProfiles.select { UserProfiles.userID eq userID }.singleOrNull()

            result?.let {
                UserProfileModel(
                    it[UserProfiles.userID],
                    it[UserProfiles.firstName],
                    it[UserProfiles.lastName],
                    it[UserProfiles.birthday],
                    it[UserProfiles.email],
                    it[UserProfiles.phoneNumber],
                    it[UserProfiles.country],
                    it[UserProfiles.city],
                    it[UserProfiles.favoriteCigarettes],
                    it[UserProfiles.profileDescription],
                    it[UserProfiles.profilePhotoURL]
                )
            }
        }
    }

    fun updateUserProfiles(userProfiles: UserProfileModel) {
        transaction {
            UserProfiles.update({ UserProfiles.userID eq userProfiles.userID }) {
                it[firstName] = userProfiles.firstName
                it[lastName] = userProfiles.lastName
                it[birthday] = userProfiles.birthday
                it[email] = userProfiles.email
                it[phoneNumber] = userProfiles.phoneNumber
                it[country] = userProfiles.country
                it[city] = userProfiles.city
                it[favoriteCigarettes] = userProfiles.favoriteCigarettes
                it[profileDescription] = userProfiles.profileDescription
                it[profilePhotoURL] = userProfiles.profilePhotoURL
            }
        }
    }

    fun deleteUserProfiles(userID: Int) {
        transaction {
            UserProfiles.deleteWhere { UserProfiles.userID eq userID }
        }
    }
}

class ProfilePhotosRepository {
    fun createProfilePhotos(profilePhotos: ProfilePhotoModel) {
        transaction {
            ProfilePhotos.insert {
                it[photoID] = profilePhotos.photoID
                it[photoURL] = profilePhotos.photoURL
                it[isMainPhoto] = profilePhotos.isMainPhoto
            }
        }
    }

    fun getProfilePhotosById(photoID: Int) : ProfilePhotoModel? {
        return transaction {
            val result = ProfilePhotos.select { ProfilePhotos.photoID eq photoID }.singleOrNull()

            result?.let {
                ProfilePhotoModel(
                    it[ProfilePhotos.userID],
                    it[ProfilePhotos.photoID],
                    it[ProfilePhotos.photoURL],
                    it[ProfilePhotos.isMainPhoto]
                )
            }
        }
    }

    fun updateProfilePhotos(profilePhotos: ProfilePhotoModel) {
        transaction {
            ProfilePhotos.update({ ProfilePhotos.photoID eq ProfilePhotos.userID }) {
                it[photoID] = profilePhotos.photoID
                it[photoURL] = profilePhotos.photoURL
                it[isMainPhoto] = profilePhotos.isMainPhoto
            }
        }
    }

    fun deleteProfilePhotos(photoID: Int) {
        transaction {
            ProfilePhotos.deleteWhere { ProfilePhotos.photoID eq photoID }
        }
    }
}

class MessagesRepository {
    fun createMessages(messages: MessageModel) {
        transaction {
            Messages.insert {
                it[messageID] = messages.messageID
                it[senderID] = messages.senderID
                it[receiverID] = messages.receiverID
                it[messageText] = messages.messageText
                it[sendDateTime] = messages.sendDateTime
            }
        }
    }

    fun getMessagesById(messageID: Int) : MessageModel? {

        return transaction {
            val result = Messages.select { Messages.messageID eq messageID }.singleOrNull()

            result?.let {
                MessageModel(
                    it[Messages.messageID],
                    it[Messages.senderID],
                    it[Messages.receiverID],
                    it[Messages.messageText],
                    it[Messages.sendDateTime]
                )
            }
        }
    }

    fun updateMessages(messages: MessageModel) {
        transaction {
            Messages.update({ Messages.messageID eq messages.messageID }) {
                it[messageID] = messages.messageID
                it[senderID] = messages.senderID
                it[receiverID] = messages.receiverID
                it[messageText] = messages.messageText
                it[sendDateTime] = messages.sendDateTime
            }
        }
    }

    fun deleteMessages(messageID: Int) {
        transaction {
            Messages.deleteWhere { Messages.messageID eq messageID }
        }
    }
}

