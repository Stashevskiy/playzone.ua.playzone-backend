package playzone.ua.database.users

data class UserEntity(
    val login: String,
    val password: String,
    val email: String?,
    val username: String
)
