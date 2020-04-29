package fr.white.under.game.presentation

import fr.white.under.game.service.GameService
import fr.white.under.role.models.Role
import fr.white.under.role.service.RoleService
import fr.white.under.user.service.UserService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.CrossOrigin

@Controller
@CrossOrigin
class GameSocketController(val template: SimpMessagingTemplate, private val userService: UserService, private val gameService: GameService, private val roleService: RoleService) {

    @MessageMapping("/app/games/{gameId}/roles")
    fun onPlayerJoined(@DestinationVariable gameId: Long, role: Role) {
        var game = gameService.findById(gameId)
        roleService.save(role)
        template.convertAndSend("/app/games/$gameId/users", userService.getNameById(role.user!!.id!!))
        template.convertAndSend("/app/games/$gameId/initRole", game.roles.map{ r -> r.user!!.name})
    }

    @MessageMapping("/app/games/{gameId}")
    fun onGameStarted(@DestinationVariable gameId: Long) {
         val game = gameService.init(gameId)
         template.convertAndSend("/app/games/$gameId", game)
    }
}
