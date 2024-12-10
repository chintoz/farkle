package es.menasoft.games.farkle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import java.util.stream.Stream

@SpringBootTest
@AutoConfigureMockMvc
class FarkleControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should return integer from query param`() {
        val result = mockMvc.get("/numbers") {
            param("numbers", "1", "2", "3", "4", "5")
        }.andExpect {
            status { isOk() }
        }.andReturn()

        val responseContent = result.response.contentAsString.toInt()
        assertEquals(150, responseContent)
    }

    @Test
    fun `should return 400 when query param is not an array of integers`() {
        mockMvc.get("/numbers") {
            param("numbers", "a", "b", "c")
        }.andExpect {
            status { isBadRequest() }
        }
    }

    companion object {
        @JvmStatic
        fun provideNumbersAndExpectedScores(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1, 5, 1, 5, 1, 5), 450),
                Arguments.of(listOf(1, 1, 1, 5, 5, 5), 1500),
                Arguments.of(listOf(2, 3, 4, 6, 2, 2), 0),
                Arguments.of(listOf(1, 1, 1, 5, 1, 2), 1150),
                Arguments.of(listOf(1, 1, 5, 5, 2, 2), 300),
                Arguments.of(listOf(6, 6, 6, 6, 5, 5), 1300),
                Arguments.of(listOf(4, 4, 4, 4, 4, 5), 1650),
                Arguments.of(listOf(3, 3, 3, 3, 3, 3), 2400),


            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbersAndExpectedScores")
    fun `should return expected score for given combination of numbers`(numbers: List<Int>, expectedScore: Int) {
        val result = mockMvc.get("/numbers") {
            param("numbers", *numbers.map { it.toString() }.toTypedArray())
        }.andExpect {
            status { isOk() }
        }.andReturn()

        val responseContent = result.response.contentAsString.toInt()
        assertEquals(expectedScore, responseContent)
    }
}