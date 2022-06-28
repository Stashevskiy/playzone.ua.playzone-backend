package playzone.ua.features.games

import kotlinx.serialization.Serializable

@Serializable
data class FetchGameRequest(
    val searchQuery: String
)
