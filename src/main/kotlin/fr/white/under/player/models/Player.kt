package fr.white.under.player.models

import fr.white.under.role.models.Role

class Player{

    val id: Int? = null

    lateinit var pseudo: String

    val roles = mutableListOf<Role>()

}