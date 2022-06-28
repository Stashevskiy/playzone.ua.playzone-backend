package playzone.ua.database.games

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

object Games: Table() {

    private val gameId = Games.varchar(name = "gameId", length = 100)
    private val title = Games.varchar(name = "name", length = 150)
    private val description = Games.varchar(name = "description", length = 500)
    private var version = Games.varchar(name = "version", length = 20)
    private var size = Games.varchar(name = "size", 20)

    fun insertGame(gameEntity: GameEntity) {
        transaction {
            Games.insert {
                it[gameId] = gameEntity.gameID
                it[title] = gameEntity.title
                it[description] = gameEntity.description
                it[version] = gameEntity.version
                it[size] = gameEntity.size
            }
        }
    }

    fun fetchGames(): List<GameEntity> {
        return try {
            transaction {
                Games.selectAll().toList()
                    .map {
                        GameEntity(
                            gameID = it[gameId],
                            title = it[title],
                            description = it[description],
                            version = it[version],
                            size = it[size]
                        )
                    }
            }
        } catch (e: Exception) {
            emptyList()
        }
    }




}