package fr.white.under.game.persistence

import fr.white.under.wordPairs.models.WordPairs

interface WordPairsDao {

    fun save(wordPairs: WordPairs): WordPairs
}
