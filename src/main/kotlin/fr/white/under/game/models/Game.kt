package fr.white.under.game.models

import com.fasterxml.jackson.annotation.JsonIgnore
import fr.white.under.role.models.Role
import fr.white.under.turn.models.Turn
import javax.persistence.*;

@Entity
data class Game(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
        val id: Long?,

        @Enumerated(EnumType.STRING)
        var status: GameStatus = GameStatus.LOBBY,

        @Column
        var civilWord: String = "",

        @Column
        var undercoverWord: String = "",

        @OneToMany(mappedBy = "game", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
        val roles: MutableList<Role> = mutableListOf(),

        @JsonIgnore
        @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
        val turns: MutableList<Turn> = mutableListOf()
)

enum class GameStatus {
    LOBBY, PLAYING, OVER
}
