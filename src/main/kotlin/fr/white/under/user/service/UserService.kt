package fr.white.under.user.service

import fr.white.under.user.models.User

interface UserService {
    fun save(user: User): User
    fun getOne(playerId: Long): User
    fun findByName(playerName: String): User
    fun findById(userId: Long): User
    fun getNameById(userId: Long): String
}
