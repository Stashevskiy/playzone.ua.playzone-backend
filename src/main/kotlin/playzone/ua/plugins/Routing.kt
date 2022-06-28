package playzone.ua.plugins

import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.PartialContent
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.io.File
import java.net.http.HttpHeaders

/*private const val BASE_URL = "http://192.168.0.2:8100"
private val rabbits = listOf(
    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL/rabbits/rabbit1.jpg"),
    Rabbit("Emma", "Emma likes to eat apples", "$BASE_URL/rabbits/rabbit2.jpg"),
    Rabbit("Florian", "Florian is always hungry", "$BASE_URL/rabbits/rabbit3.jpg"),
    Rabbit("Federico", "Federico likes to climb mountains", "$BASE_URL/rabbits/rabbit4.jpg"),
    Rabbit("Gina", "Gina is a true beauty", "$BASE_URL/rabbits/rabbit5.jpg"),
)*/


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
