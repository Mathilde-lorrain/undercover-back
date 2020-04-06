package fr.white.under.game.models

import fr.white.under.role.models.Role
import fr.white.under.turn.models.Turn

class Game{

    var id: Int? = null

    var status = GameStatus.LOBBY;

    var roles = mutableListOf<Role>()

    var turns = mutableListOf<Turn>()

}

enum class GameStatus{
    LOBBY, STARTED, OVER
}