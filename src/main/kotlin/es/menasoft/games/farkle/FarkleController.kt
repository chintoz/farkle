package es.menasoft.games.farkle

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FarkleController {

    @GetMapping("/numbers")
    fun getNumbers(@RequestParam numbers: List<Int>): Int {
        return calculateScore(numbers)
    }

    fun calculateScore(numbers: List<Int>): Int {
        var totalScore = 0
        for (number in numbers) {
            when (number) {
                1 -> totalScore += 100
                5 -> totalScore += 50
            }
        }
        return totalScore
    }
}