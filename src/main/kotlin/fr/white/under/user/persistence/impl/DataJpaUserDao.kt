package fr.white.under.user.persistence.impl

import fr.white.under.user.models.User
import fr.white.under.user.persistence.UserDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface DataJpaUserDao : UserDao, JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

}
