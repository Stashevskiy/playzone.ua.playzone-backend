package playzone.ua.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

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
        get("/random") {
            call.respondText("https://playzone-backend-ktor.herokuapp.com/memes/meme1.jpg")
        }
        static {
            resources("static")
        }
    }
}
