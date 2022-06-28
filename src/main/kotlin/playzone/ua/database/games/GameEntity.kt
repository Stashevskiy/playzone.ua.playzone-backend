package playzone.ua.database.games

data class GameEntity(
    val gameID: String,
    val title: String,
    val description: String,
    val version: String,
    val size: String
)
