package ch.keepcalm.kotlin

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
@RunWith(SpringRunner::class)
@SpringBootTest
class PlayerControllerTest() : AbstractPlayerScoreTest() {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun postPlayerScoreTest() {
        logger.info("Begin postPlayerScoreTest")

        val points = 5
        val expectedTotalScore = TEST_PLAYER_1.totalScore + points
        val expectedResult =
                "${TEST_PLAYER_1.handle} now has a total score of " +
                        "$expectedTotalScore"

        // Add 5 points to TEST_PLAYER_1's score.
        mvc.perform(MockMvcRequestBuilders
                .post("/player/${TEST_PLAYER_1.handle}/score")
                .content(points.toString()))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content()
                        .string(expectedResult))

        logger.info("End postPlayerScoreTest")
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(LeadersControllerTest::class.java)
    }
}