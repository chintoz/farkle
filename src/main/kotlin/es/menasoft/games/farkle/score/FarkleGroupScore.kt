package es.menasoft.games.farkle.score

import org.springframework.stereotype.Component

@Component
class FarkleGroupScore : GroupScore {
    override fun calculateGroupScore(group: List<Int>): Int {
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