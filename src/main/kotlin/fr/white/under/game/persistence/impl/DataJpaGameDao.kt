package fr.white.under.game.persistence.impl

import fr.white.under.game.models.Game
import fr.white.under.game.persistence.GameDao
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface DataJpaGameDao : GameDao, JpaRepository<Game, Long>, JpaSpecificationExecutor<Game> {

}
