package fr.white.under.turn.service

import fr.white.under.game.models.Game
import fr.white.under.game.persistence.GameDao
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
        private val gameDao: GameDao,
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
        if (killedPlayer.roleType != RoleType.MISTERWHITE) {
            killedPlayer.alive = false
        }
        turn.killedPlayer = killedPlayer

        val winners = getWinners(turn.game!!.roles)
        winners.forEach { w -> w.hasWon = true }

        val newTurn = newTurn(turn.game.id!!, turn.turnNumber + 1)
        val turnWinnersId = winners.map { r -> r.id }.toMutableList()

        return NewTurnDto(killedPlayer.id!!, newTurn.id!!, turnWinnersId)
    }

    @Transactional
    override fun checkMWhiteWord(gameId: Long, word: Word): NewTurnDto {
        val game = gameDao.findById(gameId)
        val mrWhiteId = word.role.id
        val winners = mutableListOf<Long?>()
        val role = game.roles.filter { r ->r.id == mrWhiteId }
        if (word.word == game.civilWord) {
            role[0].hasWon = true
            winners.add(word.role.id)
        } else {
            role[0].alive = false
            winners.addAll(getWinners(game.roles).map { r -> r.id }.toMutableList())
        }
        return NewTurnDto(null, word.turn.id!!, winners);
    }


    private fun getWinners(roles: MutableList<Role>): MutableList<Role> {
        val alive = roles.filter { r -> r.alive }
        val aliveDistinct = alive.distinctBy { r -> r.roleType }
        val roleTypeWinners = aliveDistinct.filter { r -> r.roleType.hasWon(roles) }.map { r -> r.roleType }
        return alive.filter { r -> roleTypeWinners.contains(r.roleType) }.toMutableList()
    }

    private fun getEliminatedPlayer(votes: MutableList<Vote>): Role {
        return votes.map { vote -> vote.target }.groupingBy { it }.eachCount().maxBy { it.value }!!.key
    }

    override fun newTurn(gameId: Long, turnNumber: Int): Turn {
        return save(Turn(null, turnNumber, game = entityManager.getReference(Game::class.java, gameId), killedPlayer = null))
    }
}
