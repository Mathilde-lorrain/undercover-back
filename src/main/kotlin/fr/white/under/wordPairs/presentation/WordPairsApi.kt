package fr.white.under.wordPairs.presentation
import fr.white.under.game.service.WordPairsService
import fr.white.under.wordPairs.models.WordPairs
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/wordPairs")
@CrossOrigin
class WordPairsApi(private val wordPairsService: WordPairsService) {

    @PostMapping()
    fun save(@RequestBody wordPairs: WordPairs): WordPairs {
        return wordPairsService.save(wordPairs)
    }


}
