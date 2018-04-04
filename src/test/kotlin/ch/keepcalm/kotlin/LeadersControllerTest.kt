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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LeadersControllerTest: AbstractPlayerScoreTest() {

    @Autowired
    lateinit var mvc: MockMvc

    @Test
    fun getLeadersTest() {
        logger.info("Begin getLeadersTest")

        val expectedJson = """
        |["${TEST_PLAYER_4.handle}",
        |"${TEST_PLAYER_3.handle}",
        |"${TEST_PLAYER_1.handle}"]
        """.trimMargin()

        mvc.perform(MockMvcRequestBuilders.get("/leaders"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content()
                        .json(expectedJson))

        logger.info("End getLeadersTest")
    }

    companion object {
        val logger: Logger =
                LoggerFactory.getLogger(LeadersControllerTest::class.java)
    }
}