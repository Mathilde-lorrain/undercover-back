package fr.white.under.game.persistence.impl

import fr.white.under.game.persistence.WordPairsDao
import fr.white.under.wordPairs.models.WordPairs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface DataJpaWordPairsDao : WordPairsDao, JpaRepository<WordPairs, Long>, JpaSpecificationExecutor<WordPairs> {

}
