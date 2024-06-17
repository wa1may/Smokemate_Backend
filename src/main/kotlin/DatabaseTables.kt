import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.timestamp
import org.jetbrains.exposed.sql.`java-time`.date
import java.time.Instant
import java.time.LocalDate
import org.jetbrains.exposed.sql.ReferenceOption

object  Users : IntIdTable("users") {
    val userID: Column<Int> = integer("userID").uniqueIndex()
    val login: Column<String> = varchar("login", 255).uniqueIndex()
    val passwordHash: Column<String> = varchar("passwordHash", 255).uniqueIndex()
    val registrationDate: Column<Instant> = timestamp("registrationDate")
}

object UserProfiles : IntIdTable("user_profiles") {
    val userID: Column<Int> = integer("userID").uniqueIndex().references(Users.userID, onDelete = ReferenceOption.RESTRICT, onUpdate = ReferenceOption.RESTRICT)
    val firstName: Column<String> = varchar("firstName", 255).uniqueIndex()
    val lastName: Column<String> = varchar("lastName", 255).uniqueIndex()
    val birthday: Column<LocalDate> = date("birthday")
    val email: Column<String> = varchar("email", 255).uniqueIndex()
    val phoneNumber: Column<String> = varchar("phoneNumber", 255).uniqueIndex()
    val country: Column<String> = varchar("country", 255).uniqueIndex()
    val city: Column<String> = varchar("city", 255).uniqueIndex()
    val favoriteCigarettes: Column<String> = varchar("favoriteCigarettes", 255).uniqueIndex()
    val profileDescription: Column<String> = text("profileDescription").uniqueIndex()
    val profilePhotoURL: Column<String> = varchar("profilePhotoURL", 255).uniqueIndex()
}

object ProfilePhotos : IntIdTable("profilePhotos") {
    val photoID: Column<Int> = integer("photoID").uniqueIndex()
    val userID: Column<Int> = integer("userID").uniqueIndex().references(Users.userID, onDelete = ReferenceOption.RESTRICT, onUpdate = ReferenceOption.RESTRICT)
    val photoURL: Column<String> = varchar("photoURL", 255).uniqueIndex()
    val isMainPhoto: Column<Int> = integer("isMainPhoto").uniqueIndex()
}

object Messages : IntIdTable("messages") {
    val messageID: Column<Int> = integer("messageID").uniqueIndex()
    val senderID: Column<Int> = integer("senderID").uniqueIndex().references(Users.userID, onDelete = ReferenceOption.RESTRICT, onUpdate = ReferenceOption.RESTRICT)
    val receiverID: Column<Int> = integer("receiverID").uniqueIndex().references(Users.userID, onDelete = ReferenceOption.RESTRICT, onUpdate = ReferenceOption.RESTRICT)
    val messageText: Column<String> = text("messageText").uniqueIndex()
    val sendDateTime: Column<Instant> = timestamp("sendDateTime")
}