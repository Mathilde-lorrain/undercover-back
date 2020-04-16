package fr.white.under.turn.service

import fr.white.under.role.models.Role
import fr.white.under.turn.models.Turn
import fr.white.under.turn.models.Vote
import fr.white.under.turn.models.Word
import fr.white.under.turn.presentation.NewTurnDto

interface TurnService {
    fun save(word: Word): Word
    fun save(vote: Vote): Vote
    fun save(turn: Turn): Turn
    fun endTurn(turnId: Long): NewTurnDto
    fun newTurn(gameId: Long, turnNumber: Int): Turn
}