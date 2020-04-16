package fr.white.under.game.service

import fr.white.under.game.models.Game

interface GameService {
    fun save(game: Game): Game
    fun findById(gameId: Long): Game
    fun init(gameId: Long): Game
}
