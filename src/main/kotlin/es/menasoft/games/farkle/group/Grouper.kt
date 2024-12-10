package es.menasoft.games.farkle.group

interface Grouper {
    fun createGroups(numbers: List<Int>): List<List<Int>>
}