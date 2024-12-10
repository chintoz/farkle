package es.menasoft.games.farkle.score

interface GroupScore {
    fun calculateGroupScore(group: List<Int>): Int
}