package fr.white.under.game.models

import fr.white.under.role.models.Role
import fr.white.under.turn.models.Turn
import javax.persistence.*;

@Entity
data class Game(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
        val id: Long,

        @Enumerated(EnumType.STRING)
        var status: GameStatus = GameStatus.LOBBY,

        @OneToMany(mappedBy = "game")
        val roles: MutableList<Role> = mutableListOf(),

        @OneToMany(mappedBy = "game")
        val turns: MutableList<Turn> = mutableListOf()
)

enum class GameStatus {
    LOBBY, STARTED, OVER
}
