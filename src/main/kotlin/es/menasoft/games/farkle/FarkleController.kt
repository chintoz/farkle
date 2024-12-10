package es.menasoft.games.farkle

import es.menasoft.games.farkle.group.Grouper
import es.menasoft.games.farkle.score.GroupScore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class FarkleController(@Autowired private val groupScore: GroupScore, @Autowired val grouper: Grouper) {


    @GetMapping("/numbers")
    fun getNumbers(@RequestParam numbers: List<Int>): Int {
        return numbers.createGroups().sumOf { groupScore.calculateGroupScore(it) }
    }

    private fun List<Int>.createGroups():List<List<Int>> = grouper.createGroups(this)

}


