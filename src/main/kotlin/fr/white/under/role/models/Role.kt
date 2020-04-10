package fr.white.under.role.models

import fr.white.under.game.models.Game
import fr.white.under.user.models.User
import javax.persistence.*

@Entity
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
        val id: Long?,

        @ManyToOne
        val user: User,

        @ManyToOne
        val game: Game,

        @Enumerated(EnumType.STRING)
        var roleType: RoleType = RoleType.NONE,

        @Column
        var alive: Boolean = true
)
