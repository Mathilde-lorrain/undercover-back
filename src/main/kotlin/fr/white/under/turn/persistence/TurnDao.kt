package fr.white.under.turn.persistence

import fr.white.under.turn.models.Turn
import fr.white.under.turn.models.Vote
import fr.white.under.turn.models.Word
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TurnDao {
    fun save(turn: Turn): Turn
    fun findById(voteId: Long): Turn
}

interface WordDao {
    fun save(word: Word): Word
}

interface VoteDao {
    fun save(vote: Vote): Vote
}
