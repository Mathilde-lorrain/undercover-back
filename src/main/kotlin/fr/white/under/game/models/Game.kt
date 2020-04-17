package fr.white.under.game.models

import com.fasterxml.jackson.annotation.JsonIgnore
import fr.white.under.role.models.Role
import fr.white.under.turn.models.Turn
import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import javax.persistence.*;

@Entity
data class Game(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_id_seq")
        val id: Long?,

        @Enumerated(EnumType.STRING)
        var status: GameStatus = GameStatus.LOBBY,

        @Column
        var civilWord: String = "",

        @Column
        var undercoverWord: String = "",

        @LazyCollection(LazyCollectionOption.FALSE)
        @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
        val roles: MutableList<Role> = mutableListOf(),


        @LazyCollection(LazyCollectionOption.FALSE)
        @OneToMany(mappedBy = "game", cascade = [CascadeType.ALL])
        val turns: MutableList<Turn> = mutableListOf()
)

enum class GameStatus {
    LOBBY, PLAYING, OVER
}
