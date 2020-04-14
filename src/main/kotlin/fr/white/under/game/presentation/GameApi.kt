package fr.white.under.game.presentation

import fr.white.under.game.models.Game
import fr.white.under.game.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/games")
@CrossOrigin
class GameApi(private val gameService: GameService) {

    @PostMapping()
    fun save(@RequestBody game: Game): Game {
        return gameService.save(game)
    }

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long): Game {
        return gameService.findById(id);
    }

}
