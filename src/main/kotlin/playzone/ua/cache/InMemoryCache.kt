package playzone.ua.cache

import playzone.ua.features.registration.RegisterReceiveRemote

data class TokenCache(
    val login: String,
    val token: String
)

object InMemoryCache {

    val userList: MutableList<RegisterReceiveRemote> = mutableListOf()

    val tokens: MutableList<TokenCache> = mutableListOf()

}