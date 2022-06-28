package playzone.ua.features.login

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import playzone.ua.database.tokens.TokenEntity
import playzone.ua.database.tokens.Tokens
import playzone.ua.database.users.Users
import java.util.*

class LoginController(private val call: ApplicationCall) {

    suspend fun performLogin(){

        val loginReceiveRemote = call.receive<LoginReceiveRemote>()

        val userEntity = Users.fetchUser(loginReceiveRemote.login)

        if(userEntity == null){
            call.respond(HttpStatusCode.BadRequest, "User not found")
        } else {
            if(userEntity.password == loginReceiveRemote.password){
                val token = UUID.randomUUID().toString()
                Tokens.insertToken(TokenEntity(
                    rowId = UUID.randomUUID().toString(),
                    login = loginReceiveRemote.login,
                    token = token
                ))
                call.respond(LoginResponseRemote(token = token))
            } else {
                call.respond(HttpStatusCode.BadRequest, "Invalid password")
            }
        }

    }

}