package ch.keepcalm.kotlin.playerscore

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface PlayerService {

    fun leaders(): List<Player>
    fun score(handle: String, points: Int) : Int

}

@Service("playerService")
class PlayerServiceImpl : PlayerService{

    @Autowired
    lateinit var playerRepository: PlayerRepository

    override fun leaders(): List<Player> {
        return playerRepository.findTop3ByOrderByTotalScoreDesc()
    }

    override fun score(handle: String, points: Int): Int {
        val player = playerRepository
                .findById(handle).orElse(Player(handle))
        + points

        // Save it
        playerRepository.save(player)
        return player.totalScore
    }

}