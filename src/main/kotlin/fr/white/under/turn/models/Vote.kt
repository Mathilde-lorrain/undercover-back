package fr.white.under.turn.models

import fr.white.under.role.models.Role
import javax.persistence.*

@Entity
data class Vote(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vote_id_seq")
        val id: Long,

        @ManyToOne
        val turn: Turn,

        @ManyToOne
        val voter: Role,

        @ManyToOne
        val target: Role
)
