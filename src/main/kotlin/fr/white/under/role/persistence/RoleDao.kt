package fr.white.under.role.persistence

import fr.white.under.role.models.Role

interface RoleDao {
    fun save(role: Role): Role
}
