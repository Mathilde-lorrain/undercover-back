package fr.white.under.role.models

import com.fasterxml.jackson.annotation.JsonProperty
import fr.white.under.game.models.Game
import fr.white.under.user.models.User
import javax.persistence.*

@Entity
data class Role(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq")
        val id: Long?,

        @ManyToOne
        val user: User?,

        @ManyToOne
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val game: Game?,

        @Enumerated(EnumType.STRING)
        var roleType: RoleType = RoleType.NONE,

        @Column
        var alive: Boolean = true
)
