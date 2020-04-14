package fr.white.under.role.service

import fr.white.under.role.models.Role

interface RoleService {
    fun save(role: Role): Role
}
