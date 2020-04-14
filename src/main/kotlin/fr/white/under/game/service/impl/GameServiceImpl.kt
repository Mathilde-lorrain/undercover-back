package fr.white.under.game.service.impl

import fr.white.under.game.models.Game
import fr.white.under.game.persistence.GameDao
import fr.white.under.game.service.GameService
import fr.white.under.role.models.RoleType
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
open class GameServiceImpl(private val gameDao: GameDao) : GameService {

    override fun giveRole(game: Game) {
        val defaultRoles = RoleType.getDefaultRolesTypes(game.roles.size)
        defaultRoles.shuffle()
        game.roles.forEachIndexed { i, role ->
            role.roleType = defaultRoles[i]
        }
    }

    override fun giveWord(game: Game) {
        game.civilWord = "chien"
        game.undercoverWord = "chat"
    }

    override fun findById(gameId: Long): Game {
        return gameDao.findById(gameId)
    }

    @Transactional
    override fun save(game: Game): Game {
        return gameDao.save(game)
    }

}
