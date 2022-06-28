package playzone.ua.database.tokens

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Tokens: Table() {

    private val id = Tokens.varchar("id", 50)
    private val login = Tokens.varchar("login", 25)
    private val token = Tokens.varchar("token", 50)

    fun insertToken(tokenEntity: TokenEntity){
        transaction {
            Tokens.insert {
                it[Tokens.id] = tokenEntity.rowId
                it[login] = tokenEntity.login
                it[token] = tokenEntity.token
            }
        }
    }

    fun fetchTokens(): List<TokenEntity> {
        return try {
            transaction {
                Tokens.selectAll().toList()
                    .map {
                        TokenEntity(
                            rowId = it[Tokens.id],
                            token = it[token],
                            login = it[login]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

}