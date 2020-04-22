package fr.white.under.wordPairs.models


import javax.persistence.*

@Entity
data class WordPairs(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_pairs_id_seq")
        val id: Long?,

        var word1: String,

        var word2: String
)
