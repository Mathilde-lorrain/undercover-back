package fr.white.under.user.presentation

import fr.white.under.user.models.User
import fr.white.under.user.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/login")
@CrossOrigin
class LoginApi(private val userService: UserService) {

    @PostMapping()
    fun login(@RequestBody name: String): User {
        return userService.findByName(name)
    }

}
