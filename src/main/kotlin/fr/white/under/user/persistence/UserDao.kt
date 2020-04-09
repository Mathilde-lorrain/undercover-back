package fr.white.under.user.persistence

import fr.white.under.user.models.User

interface UserDao {

    fun save(user: User): User
    fun getOne(playerId: Long): User
    fun findByName(playerName: String): User
}
