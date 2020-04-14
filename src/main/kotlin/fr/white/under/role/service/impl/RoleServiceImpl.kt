package fr.white.under.role.service.impl

import fr.white.under.game.persistence.impl.DataJpaRoleDao
import fr.white.under.role.models.Role
import fr.white.under.role.persistence.RoleDao
import fr.white.under.role.service.RoleService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
open class RoleServiceImpl(private val roleDao: RoleDao, private val dataJpaRoleDao: DataJpaRoleDao) : RoleService {

    @Transactional
    override fun save(role: Role): Role {
        return roleDao.save(role)
    }
}
