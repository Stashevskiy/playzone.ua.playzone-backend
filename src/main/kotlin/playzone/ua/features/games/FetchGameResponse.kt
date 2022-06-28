package playzone.ua.features.games

import kotlinx.serialization.Serializable
import playzone.ua.database.games.GameEntity

@Serializable
data class FetchGamesResponse(
    val games: List<GameResponse>
)

@Serializable
data class GameResponse(
    val gameId: String,
    val title: String,
    val description: String,
    val version: String,
    val size: String
)

fun GameEntity.mapToGameResponse(): GameResponse {
    return GameResponse(
        gameId = gameID,
        title = title,
        description = description,
        version = version,
        size = size
    )
}
