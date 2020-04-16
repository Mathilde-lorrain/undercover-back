package fr.white.under.turn.persistence

import fr.white.under.game.models.Game
import fr.white.under.game.persistence.GameDao
import fr.white.under.turn.models.Turn
import fr.white.under.turn.models.Vote
import fr.white.under.turn.models.Word
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository


@Repository
interface DataJpaTurnDao : TurnDao, JpaRepository<Turn, Long>, JpaSpecificationExecutor<Turn> {

}

@Repository
interface DataJpaWordDao : WordDao, JpaRepository<Word, Long>, JpaSpecificationExecutor<Word> {

}

@Repository
interface DataJpaVoteDao : VoteDao, JpaRepository<Vote, Long>, JpaSpecificationExecutor<Vote> {

}