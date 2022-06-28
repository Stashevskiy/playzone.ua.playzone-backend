package playzone.ua.features.games

import kotlinx.serialization.Serializable
import playzone.ua.database.games.GameEntity
import java.util.*

@Serializable
data class CreateGameRequest(
    val title: String,
    val description: String,
    val version: String,
    val size: String
)

fun CreateGameRequest.mapToGameEntity(): GameEntity  =
    GameEntity(
        gameID = UUID.randomUUID().toString(),
        title = title,
        description = description,
        version = version,
        size = size
    )

fun GameEntity.mapToCreateGameResponse(): CreateGameResponse =
    CreateGameResponse(
        gameID = gameID,
        title = title,
        description = description,
        version = version,
        size = size
    )

@Serializable
data class CreateGameResponse(
    val gameID: String,
    val title: String,
    val description: String,
    val version: String,
    val size: String
)