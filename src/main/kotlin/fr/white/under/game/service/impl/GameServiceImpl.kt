package fr.white.under.game.service.impl

import fr.white.under.game.models.Game
import fr.white.under.game.persistence.GameDao
import fr.white.under.game.service.GameService
import org.springframework.stereotype.Service

@Service
class GameServiceImpl(private val gameDao: GameDao) : GameService {

    override fun getOne(gameId: Long): Game {
        return gameDao.getOne(gameId)
    }

    override fun save(game: Game): Game {
        return gameDao.save(game)
    }

}
