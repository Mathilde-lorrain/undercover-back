package fr.white.under.turn.models

import fr.white.under.role.models.Role
import javax.persistence.*

@Entity
data class Word(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_id_seq")
        val id: Long?,

        @ManyToOne
        val turn: Turn,

        @ManyToOne
        val role: Role,

        @Column
        val word: String
)
