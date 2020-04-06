package fr.white.under

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UnderApplication

fun main(args: Array<String>) {
    runApplication<UnderApplication>(*args)
}
