package fr.white.under.game.persistence.impl

import fr.white.under.role.models.Role
import fr.white.under.role.persistence.RoleDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface DataJpaRoleDao : RoleDao, JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {
}
