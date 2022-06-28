package playzone.ua.database.users

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction


object Users: Table() {

    private val login = Users.varchar("login", 25)
    private val password = Users.varchar("password", 25)
    private val username = Users.varchar("username", 30)
    private val email = Users.varchar("email", 25)

    fun insertUser(userEntity: UserEntity){
        transaction {
            Users.insert {
                it[login] = userEntity.login
                it[password] = userEntity.password
                it[username] = userEntity.username
                it[email] = userEntity.email.orEmpty()
            }
        }
    }

    fun fetchUser(login: String): UserEntity? {
        return try {
            transaction {
                val userEntity = Users.select {
                    Users.login.eq(login)
                }.single()
                UserEntity(
                    login = userEntity[Users.login],
                    password = userEntity[password],
                    email = userEntity[email],
                    username = userEntity[username]
                )
            }
        } catch (e: Exception){
            null
        }
    }

}