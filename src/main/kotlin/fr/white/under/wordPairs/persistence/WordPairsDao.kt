package fr.white.under.game.persistence

import fr.white.under.wordPairs.models.WordPairs
import org.springframework.data.jpa.repository.Query

interface WordPairsDao {

    fun save(wordPairs: WordPairs): WordPairs

    @Query(value="SELECT * FROM word_pairs ORDER BY random() LIMIT 1",nativeQuery = true)
    fun findRandomOne(): WordPairs

}
