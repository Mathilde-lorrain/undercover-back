package fr.white.under.game.persistence

import fr.white.under.game.models.Game

interface GameDao {

    fun save(game: Game): Game
    fun findById(gameId: Long): Game
}
