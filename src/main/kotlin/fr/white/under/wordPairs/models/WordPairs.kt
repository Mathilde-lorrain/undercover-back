package fr.white.under.wordPairs.models


import javax.persistence.*

@Entity
data class WordPairs(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_peers_id_seq")
        val id: Long?,

        val word1: String,

        val word2: String
)
