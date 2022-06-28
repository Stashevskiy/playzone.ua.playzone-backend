package playzone.ua.plugins

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {

    routing {
        get("/test") {
            call.respondText("Hello, World")
        }
    }

}
