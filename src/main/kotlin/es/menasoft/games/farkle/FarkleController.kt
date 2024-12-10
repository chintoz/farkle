package es.menasoft.games.farkle

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FarkleController {

    @GetMapping("/numbers")
    fun getNumbers(@RequestParam numbers: List<Int>): Int {
        return calculateTotalScore(numbers)
    }

    fun calculateTotalScore(numbers: List<Int>): Int {
        var totalScore = 0
        var currentGroup = ArrayList<Int>()
        for (number in numbers) {
            if (currentGroup.size == 0) {
                currentGroup.add(number)
            } else {
                if (currentGroup[0] == number) {
                    currentGroup.add(number)
                } else {
                    totalScore += calculateGroupScore(currentGroup)
                    currentGroup.clear()
                    currentGroup.add(number)
                }
            }
        }
        totalScore += calculateGroupScore(currentGroup)
        return totalScore
    }

    fun calculateGroupScore(group: List<Int>): Int {
        if (group.isEmpty()) return 0

        val count = group.size
        val number = group[0]

        return when {
            count == 6 -> number * 8 * 100
            count == 5 -> number * 4 * 100
            count == 4 -> number * 2 * 100
            count == 3 -> when (number) {
                1 -> 1000
                else -> number * 100
            }

            count == 2 -> when (number) {
                1 -> 200
                5 -> 100
                else -> 0
            }

            count == 1 -> when (number) {
                1 -> 100
                5 -> 50
                else -> 0
            }

            else -> 0
        }
    }
}