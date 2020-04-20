package fr.white.under.wordPairs.service.impl

import fr.white.under.game.persistence.WordPairsDao
import fr.white.under.game.service.WordPairsService
import fr.white.under.wordPairs.models.WordPairs
import org.springframework.stereotype.Service

@Service
open class WordPairsServiceImpl(private val wordPairsDao: WordPairsDao) : WordPairsService {

    override fun findRandomOne(): WordPairs {
       return wordPairsDao.findRandomOne()
    }

    override fun save(wordPairs: WordPairs): WordPairs {
        return wordPairsDao.save(wordPairs)
    }


}
