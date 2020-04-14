package fr.white.under.user.presentation

import fr.white.under.user.models.User
import fr.white.under.user.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
@CrossOrigin
class UserApi(private val userService: UserService) {

    @PostMapping()
    fun save(@RequestBody user: User): User {
        return userService.save(user)
    }

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long): User {
        return userService.getOne(id);
    }

}
