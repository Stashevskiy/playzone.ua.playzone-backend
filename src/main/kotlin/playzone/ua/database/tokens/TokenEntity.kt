package playzone.ua.database.tokens

data class TokenEntity(
    val rowId: String,
    val login: String,
    val token: String
)
