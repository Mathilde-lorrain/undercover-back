package fr.white.under.user.service.impl

import fr.white.under.user.models.User
import fr.white.under.user.persistence.UserDao
import fr.white.under.user.service.UserService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
open class UserServiceImpl(private val userDao: UserDao) : UserService {

    override fun findById(userId: Long): User {
        return userDao.findById(userId)
    }

    override fun getNameById(userId: Long): String {
        return userDao.getNameById(userId)
    }

    override fun findByName(playerName: String): User {
        return userDao.findByName(playerName)
    }

    override fun getOne(playerId: Long): User {
        return userDao.getOne(playerId)
    }

    @Transactional
    override fun save(userId: User): User {
        return userDao.save(userId)
    }

}
