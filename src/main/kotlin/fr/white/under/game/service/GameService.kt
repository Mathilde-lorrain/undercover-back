package fr.white.under.game.service

import fr.white.under.game.models.Game

interface GameService {
    fun save(game: Game): Game
    fun getOne(gameId: Long): Game
}
