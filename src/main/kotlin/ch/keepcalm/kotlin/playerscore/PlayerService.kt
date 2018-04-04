package ch.keepcalm.kotlin.playerscore

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("playerService")
class PlayerService {

    @Autowired
    lateinit var playerRepository: PlayerRepository

      fun leaders(): List<Player> =
            playerRepository.findTop3ByOrderByTotalScoreDesc()

      fun score(handle: String, points: Int) : Int {
        val player = playerRepository
                .findById(handle).orElse(Player(handle)) + points
        playerRepository.save(player)
        return player.totalScore
      }

}