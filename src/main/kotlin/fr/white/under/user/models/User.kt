package fr.white.under.user.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import fr.white.under.role.models.Role
import javax.persistence.*

@Entity(name = "users")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
        val id: Long?,

        @Column
        val name: String?,

        @Column
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
        val password: String?,

        @OneToMany(mappedBy = "user")
        @JsonIgnore
        val roles: MutableList<Role> = mutableListOf()
)
