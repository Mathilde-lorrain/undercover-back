package fr.white.under.turn.presentation

import fr.white.under.turn.models.Vote
import fr.white.under.turn.models.Word
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.messaging.simp.SimpMessagingTemplate

@Controller
class TurnSocketController(val template: SimpMessagingTemplate) {

    @MessageMapping("/app/games/{gameId}/words")
    fun onWordReceived(@DestinationVariable gameId: Long, word: Word) {
        //TODO wordService.save(word)
        template.convertAndSend("/app/games/$gameId/words", word)
    }

    @MessageMapping("/app/games/{gameId}/turns")
    fun onVoteReceived(@DestinationVariable gameId: Long, vote: Vote) {
        //TODO voteService.save(vote)
        if(vote.isLast){
            //TODO voteService.whoIsEliminated(vote.turn.id)
            template.convertAndSend("/app/games/$gameId/turns", "eliminatedPlayer")
        }
        template.convertAndSend("/app/games/$gameId/votes", vote)
    }
}
