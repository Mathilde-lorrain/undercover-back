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
    fun onAddPlayer(@DestinationVariable gameId: Long, role: Role) {
        roleService.save(role)
        template.convertAndSend("/app/games/$gameId/users", userService.getNameById(role.user.id!!))
    }

    @MessageMapping("/app/games/{id}")
    fun onStartGame(@DestinationVariable gameId: Long) {
         val game = gameService.findById(gameId)
         gameService.giveRole(game)
         gameService.giveWord(game)
         template.convertAndSend("/app/games/$gameId", game)
    }
}
