package fr.white.under.role.models

import fr.white.under.game.models.Game
import fr.white.under.player.models.Player

class Role {

    val id: Int? = null

    lateinit var player: Player

    lateinit var game: Game

    var roleType = RoleType.NONE

    var alive = true

}