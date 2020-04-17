package fr.white.under.turn.presentation

import fr.white.under.turn.models.Vote
import fr.white.under.turn.models.Word
import fr.white.under.turn.service.TurnService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.messaging.simp.SimpMessagingTemplate

@Controller
class TurnSocketController(val template: SimpMessagingTemplate, private val turnService: TurnService) {

    @MessageMapping("/app/games/{gameId}/words")
    fun onWordReceived(@DestinationVariable gameId: Long, word: Word) {
        turnService.save(word)
    }

    @MessageMapping("/app/games/{gameId}/votes")
    fun onVoteReceived(@DestinationVariable gameId: Long, vote: Vote) {
        turnService.save(vote)

        if (vote.isLast) {
            template.convertAndSend("/app/games/$gameId/turns", turnService.endTurn(vote.turn.id!!))
        }
    }
}
