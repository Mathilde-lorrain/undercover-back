package fr.white.under.turn.models

import fr.white.under.game.models.Game
import fr.white.under.role.models.Role
import javax.persistence.*

@Entity
data class Turn(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turn_id_seq")
        val id: Long?,

        @Column
        val turnNumber: Int,

        @OneToMany(mappedBy = "turn")
        val votes: MutableList<Vote> = mutableListOf(),

        @OneToMany(mappedBy = "turn")
        val words: MutableList<Word> = mutableListOf(),

        @ManyToOne
        val game: Game,

        @ManyToOne
        val killedPlayer: Role?
)
