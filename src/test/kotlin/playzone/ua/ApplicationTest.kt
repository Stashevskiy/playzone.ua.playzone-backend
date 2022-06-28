package playzone.ua

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import org.jetbrains.exposed.sql.Database
import playzone.ua.plugins.configureRouting
import playzone.ua.plugins.configureSerialization
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Ok", bodyAsText())
        }
    }

    /*@Test
    fun testRegister() = testApplication {
        application {
            defaultConfiguration()
            configureRegisterRouting()
        }
        client.post("/register") {
            val string = Json.encodeToString(RegisterReceiveRemote(
                login = "Test",
                email = "test@test.ru",
                password = "Test"
            ))
            setBody(string)
        }.apply {
            assert(status == HttpStatusCode.Conflict)
        }
    }*/

}

fun Application.defaultConfiguration(){
    Database.connect("jdbc:postgresql://ec2-52-30-159-47.eu-west-1.compute.amazonaws.com:5432/d254ibomundrui",
        driver = "org.postgresql.Driver",
        user = "ffjgddoexxosrx",password = "c5f2b12e811ed461f26e73dba3f17a8279345e41d5b1c1c950fe5388d42f6523")

    configureSerialization()
}