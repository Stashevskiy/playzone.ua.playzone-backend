package playzone.ua

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import playzone.ua.features.games.configureGamesRouting
import playzone.ua.features.login.configureLoginRouting
import playzone.ua.features.registration.configureRegisterRouting
import playzone.ua.plugins.configureRouting
import playzone.ua.plugins.configureSerialization

fun main() {

    /*val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)*/

    Database.connect("jdbc:postgresql://ec2-52-30-159-47.eu-west-1.compute.amazonaws.com:5432/d254ibomundrui",
        driver = "org.postgresql.Driver",
        user = "ffjgddoexxosrx",password = "c5f2b12e811ed461f26e73dba3f17a8279345e41d5b1c1c950fe5388d42f6523")

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureGamesRouting()
        configureSerialization()

    }.start(wait = true)
}
