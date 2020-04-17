package fr.white.under.turn.service

import com.fasterxml.jackson.annotation.JsonView
import fr.white.under.game.models.Game
import fr.white.under.game.persistence.GameDao
import fr.white.under.game.service.GameService
import fr.white.under.role.models.Role
import fr.white.under.role.models.RoleType
import fr.white.under.turn.models.Turn
import fr.white.under.turn.models.Vote
import fr.white.under.turn.models.Word
import fr.white.under.turn.persistence.TurnDao
import fr.white.under.turn.persistence.VoteDao
import fr.white.under.turn.persistence.WordDao
import fr.white.under.turn.presentation.NewTurnDto
import org.springframework.stereotype.Service
import javax.persistence.EntityManager
import javax.transaction.Transactional

@Service
open class TurnServiceImpl(
        private val turnDao: TurnDao,
        private val wordDao: WordDao,
        private val voteDao: VoteDao,
        private val entityManager: EntityManager
) : TurnService {
    override fun save(word: Word): Word {
        return wordDao.save(word)
    }

    override fun save(vote: Vote): Vote {
        return voteDao.save(vote)
    }

    override fun save(turn: Turn): Turn {
        return turnDao.save(turn)
    }

    @Transactional
    override fun endTurn(turnId: Long): NewTurnDto {
        val turn = turnDao.findById(turnId)

        val killedPlayer = getEliminatedPlayer(turn.votes)
        killedPlayer.alive = false
        turn.killedPlayer = killedPlayer

        val winners = getWinnersPlayer(turn.game!!.roles)

        val newTurn = newTurn(turn.game!!.id!!, turn.turnNumber + 1)
        val turnWinnersId = winners.map { r -> r.id }.toMutableList()

        return NewTurnDto(killedPlayer.id!!, newTurn.id!!, turnWinnersId)
    }


    private fun getWinnersPlayer(roles : MutableList<Role>): MutableList<Role> {
        var alive = roles.filter { r -> r.alive }
        var aliveDistinct = alive.distinctBy { r -> r.roleType }
        var roleTypeWinners = aliveDistinct.filter { r -> r.roleType.hasWon(roles) }.map { r -> r.roleType }
        return alive.filter { r -> roleTypeWinners.contains(r.roleType)}.toMutableList()
    }

    private fun getEliminatedPlayer(votes: MutableList<Vote>): Role {
        return votes.map { vote -> vote.target }.groupingBy { it }.eachCount().maxBy { it.value }!!.key
    }

    override fun newTurn(gameId: Long, turnNumber: Int): Turn {
        return save(Turn(null, turnNumber, game = entityManager.getReference(Game::class.java, gameId), killedPlayer = null))
    }
}
