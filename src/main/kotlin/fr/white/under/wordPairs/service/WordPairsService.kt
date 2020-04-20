package fr.white.under.game.service

import fr.white.under.wordPairs.models.WordPairs

interface WordPairsService {
    fun save(wordPairs: WordPairs): WordPairs
    fun findRandomOne(): WordPairs
}
