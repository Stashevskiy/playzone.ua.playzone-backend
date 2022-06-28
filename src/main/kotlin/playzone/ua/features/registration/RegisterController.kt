package playzone.ua.features.registration

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import org.jetbrains.exposed.exceptions.ExposedSQLException
import playzone.ua.database.tokens.TokenEntity
import playzone.ua.database.tokens.Tokens
import playzone.ua.database.users.UserEntity
import playzone.ua.database.users.Users
import playzone.ua.utils.isValidEmail
import java.util.*

class RegisterController(private val call: ApplicationCall) {

    suspend fun registerNewUser() {

        val registerReceiveRemote = call.receive<RegisterReceiveRemote>()

        if(!registerReceiveRemote.email.isValidEmail()){
            call.respond(HttpStatusCode.BadRequest, "Email is not valid")
        }

        val userEntity = Users.fetchUser(registerReceiveRemote.login)

        if(userEntity != null){
            call.respond(HttpStatusCode.Conflict, "User already exists")
        } else {
            val token = UUID.randomUUID().toString()
            Tokens.insertToken(TokenEntity(
                rowId = UUID.randomUUID().toString(),
                login = registerReceiveRemote.login,
                token = token
            ))

            Users.insertUser(UserEntity(
                login = registerReceiveRemote.login,
                password = registerReceiveRemote.password,
                email = registerReceiveRemote.email,
                username = ""
            ))
            call.respond(RegisterResponseRemote(token = token))

            /*try{
                Users.insertUser(UserEntity(
                    login = registerReceiveRemote.login,
                    password = registerReceiveRemote.password,
                    email = registerReceiveRemote.email,
                    username = ""
                ))
                call.respond(RegisterResponseRemote(token = token))
            } catch (e: ExposedSQLException){
                call.respond(HttpStatusCode.Conflict, "User already exists")
            }*/

        }

    }

}