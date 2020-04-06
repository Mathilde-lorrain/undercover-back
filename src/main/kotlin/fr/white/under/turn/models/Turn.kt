package fr.white.under.turn.models

import com.fasterxml.jackson.annotation.JsonIgnore
import fr.white.under.player.models.Player

class Turn {

    val votes = mutableListOf<Vote>()

    val words = mutableListOf<Word>()

    var turnNumber: Int = 0

    lateinit var killedPlayer: Player
}