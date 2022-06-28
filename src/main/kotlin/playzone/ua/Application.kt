package playzone.ua

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.jetbrains.exposed.sql.Database
import playzone.ua.features.games.configureGamesRouting
import playzone.ua.features.login.configureLoginRouting
import playzone.ua.features.registration.configureRegisterRouting
import playzone.ua.plugins.*

fun main() {

    val config = HikariConfig("hikari.properties")
    val dataSource = HikariDataSource(config)
    Database.connect(dataSource)

    /*Database.connect("jdbc:postgresql://localhost:5432/playzone", driver = "org.postgresql.Driver",
        user = "postgres",password = "1234")*/

    embeddedServer(Netty, port = System.getenv("PORT").toInt()) {
        configureRouting()
        configureLoginRouting()
        configureRegisterRouting()
        configureGamesRouting()
        configureSerialization()

    }.start(wait = true)
}
