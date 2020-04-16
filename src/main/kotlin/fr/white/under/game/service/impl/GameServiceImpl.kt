package fr.white.under.game.service.impl

import fr.white.under.game.models.Game
import fr.white.under.game.models.GameStatus
import fr.white.under.game.persistence.GameDao
import fr.white.under.game.service.GameService
import fr.white.under.role.models.RoleType
import fr.white.under.turn.service.TurnService
import org.springframework.stereotype.Service
import javax.transaction.Transactional
import kotlin.random.Random

@Service
open class GameServiceImpl(private val gameDao: GameDao, private val turnService: TurnService) : GameService {

    override fun findById(gameId: Long): Game {
        return gameDao.findById(gameId)
    }

    @Transactional
    override fun save(game: Game): Game {
        return gameDao.save(game)
    }

    @Transactional
    override fun init(gameId: Long): Game {
        val game = findById(gameId)
        if(game.roles.size < 3){
            TODO("Not enough players !!")
        }
        game.status = GameStatus.PLAYING
        giveWord(game)
        giveRole(game)
        game.turns.add(turnService.newTurn(gameId, 1))
        return game
    }

    private fun giveRole(game: Game) {
        val defaultRoles = RoleType.getDefaultRolesTypes(game.roles.size)
        defaultRoles.shuffle()
        game.roles.forEachIndexed { i, role ->
            role.roleType = defaultRoles[i]
        }
        game.roles.shuffle()
        if(game.roles[0].roleType == RoleType.MISTERWHITE)
        {
            val misterWhite = game.roles.removeAt(0)
            game.roles.add(Random.nextInt(1, game.roles.size + 1), misterWhite)
        }
    }

    private fun giveWord(game: Game) {
        game.civilWord = "chien"
        game.undercoverWord = "chat"
    }
}
