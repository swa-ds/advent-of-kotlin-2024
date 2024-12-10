package day05

import java.io.File

private fun toIntsList(it: String) = it.split(",").map { it.toInt() }.toList()

fun List<Int>.tail(): List<Int> = this.subList(1, this.size)
fun List<Int>.middlePage(): Int = this[this.size / 2]

fun calculateMiddlePagesSum(input: List<String>): Int {

    val rulesMap = getRulesMap(input)
    val pagesList = getPagesList(input)

    fun inCorrectOrder(pages: List<Int>): Boolean {
        if (pages.size <= 1) {
            return true
        }
        val head = pages.first()
        val tail = pages.tail()
        if (tail.any { rulesMap[it]?.contains(head) == true }) {
            return false
        }
        return inCorrectOrder(tail)
    }

    val sum = pagesList
        .filter { inCorrectOrder(it) }
        .map { it.middlePage() }
        .sum()

    return sum
}

fun getRulesMap(input: List<String>): Map<Int, List<Int>> {
    var map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    input.takeWhile { it.isNotEmpty() }
        .forEach {
            val split = it.split("|")
            map.getOrPut(split[0].toInt()) { mutableListOf() }.add(split[1].toInt())
        }
    return map
}

fun getPagesList(input: List<String>): List<List<Int>> {
    val pagesList = input
        .filter { it.contains(",") }
        .map { toIntsList(it) }
    return pagesList
}

fun main() {
    val f = File("input.txt")
    println(f.absolutePath)
    val input = f.readLines()

    println("Part 1: ${calculateMiddlePagesSum(input)}")
}
