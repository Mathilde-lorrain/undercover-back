package fr.white.under.turn.service

import fr.white.under.game.models.Game
import fr.white.under.role.models.Role
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

        //TODO check win here

        val newTurn = newTurn(turn.game!!.id!!, turn.turnNumber + 1)


        return NewTurnDto(killedPlayer.id!!, newTurn.id!!)
    }

    private fun getEliminatedPlayer(votes: MutableList<Vote>): Role {
        return votes.map { vote -> vote.target }.groupingBy { it }.eachCount().maxBy { it.value }!!.key
    }

    override fun newTurn(gameId: Long, turnNumber: Int): Turn{
        return save(Turn(null, turnNumber, game = entityManager.getReference(Game::class.java, gameId), killedPlayer = null))
    }
}
