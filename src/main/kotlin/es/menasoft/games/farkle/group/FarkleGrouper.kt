package es.menasoft.games.farkle.group

import org.springframework.stereotype.Component

@Component
class FarkleGrouper: Grouper {
    override fun createGroups(numbers: List<Int>): List<List<Int>> {
        val groups = ArrayList<List<Int>>()
        var currentGroup = ArrayList<Int>()
        for (number in numbers) {
            if (currentGroup.size == 0) {
                currentGroup.add(number)
            } else {
                if (currentGroup[0] == number) {
                    currentGroup.add(number)
                } else {
                    groups.add(currentGroup)
                    currentGroup = ArrayList()
                    currentGroup.add(number)
                }
            }
        }
        groups.add(currentGroup)
        return groups
    }
}