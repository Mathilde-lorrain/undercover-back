package fr.white.under.wordPairs.service.impl

import fr.white.under.game.persistence.WordPairsDao
import fr.white.under.game.service.WordPairsService
import fr.white.under.wordPairs.models.WordPairs
import org.springframework.stereotype.Service
import java.text.Normalizer

@Service
open class WordPairsServiceImpl(private val wordPairsDao: WordPairsDao) : WordPairsService {

    override fun findRandomOne(): WordPairs {
       return wordPairsDao.findRandomOne()
    }

    override fun save(wordPairs: WordPairs): WordPairs {
        wordPairs.word1 = wordPairs.word1.toLowerCase()
        wordPairs.word2 = wordPairs.word2.toLowerCase()
        return wordPairsDao.save(wordPairs)
    }
}
