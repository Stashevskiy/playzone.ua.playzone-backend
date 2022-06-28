package playzone.ua.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

val links = listOf(
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon1.jpg",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon2.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon3.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon4.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon5.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon6.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon7.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon8.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon9.png",
    "https://playzone-backend-ktor.herokuapp.com/pokemons/pokemon10.png",
)

fun Application.configureRouting() {

    routing {
        get("/test") {
            call.respondText("Hello, World")
        }
    }

    routing {
        get("/") {
            call.respondText("Ok")
        }
    }

    routing {
        get("/random-pokemon") {
            call.respondRedirect(links.random())
        }
        static {
            resources("static")
        }
    }
}
