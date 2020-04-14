package fr.white.under.user.persistence

import fr.white.under.user.models.User
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserDao {

    fun save(user: User): User
    fun getOne(playerId: Long): User
    fun findByName(playerName: String): User
    fun findById(userId: Long): User
    @Query("select u.name from users u where u.id = (:userId)")
    fun getNameById(@Param("userId") userId: Long): String
}
