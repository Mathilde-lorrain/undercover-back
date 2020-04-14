package fr.white.under.turn.models

import com.fasterxml.jackson.annotation.JsonIgnore
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

        @OneToMany
        val votes: MutableList<Vote> = mutableListOf(),

        @OneToMany
        val words: MutableList<Word> = mutableListOf(),

        @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH])
        val game: Game,

        @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH])
        val killedPlayer: Role?
)
