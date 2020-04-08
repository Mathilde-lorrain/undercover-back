package fr.white.under.user.service.impl

import fr.white.under.user.models.User
import fr.white.under.user.persistence.UserDao
import fr.white.under.user.service.UserService
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val userDao: UserDao) : UserService {

    override fun getOne(playerId: Long): User {
        return userDao.getOne(playerId)
    }

    override fun save(userId: User): User {
        return userDao.save(userId)
    }

}
