package fr.white.under.user.models

import fr.white.under.role.models.Role
import javax.persistence.*

@Entity(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
        val id: Long?=null ,

        @Column
        val name: String="",

        @Column
        val password: String="",

        @OneToMany(mappedBy = "user")
        val roles: MutableList<Role> = mutableListOf()
)
