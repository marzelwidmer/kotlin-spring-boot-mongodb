package ch.keepcalm.kotlin.playerscore

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

/*
A Player has three elements: the player’s handle (also its unique identifier),
the total score, and the history of score events.
Each score event is just a timestamp and the points scored.
 */
@TypeAlias("player") // MongoDb _class name without package
data class Player(@Id val handle: String,
                  val totalScore: Int = 0,
                  val history: List<ScoreEvent> = listOf()) {

    // overloading of (+) plus method
    operator fun plus(score: Int) = Player(handle, totalScore + score, history + ScoreEvent(score))
}

