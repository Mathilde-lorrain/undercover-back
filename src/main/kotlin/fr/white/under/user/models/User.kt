package fr.white.under.user.models

import fr.white.under.role.models.Role
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
        val id: Long?,

        @Column
        val name: String,

        @Column
        val password: String,

        @OneToMany(mappedBy = "user")
        val roles: MutableList<Role> = mutableListOf()
)
