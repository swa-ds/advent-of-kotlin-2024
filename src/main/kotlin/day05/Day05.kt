package day05

import java.io.File

private fun toIntsList(it: String) = it.split(",").map { it.toInt() }.toList()

fun List<Int>.tail(): List<Int> = this.subList(1, this.size)
fun List<Int>.middlePage(): Int = this[this.size / 2]

fun inCorrectOrder(pages: List<Int>, rules: Map<Int, List<Int>>): Boolean {
    if (pages.size <= 1) {
        return true
    }
    val head = pages.first()
    val tail = pages.tail()
    if (tail.any { rules[it]?.contains(head) == true }) {
        return false
    }
    return inCorrectOrder(tail, rules)
}

fun solvePart1(sortRules: Map<Int, List<Int>>, pagesList: List<List<Int>>): Int {
    return pagesList
        .filter { inCorrectOrder(it, sortRules) }
        .sumOf { it.middlePage() }
}

fun solvePart2(sortRules: Map<Int, List<Int>>, pagesList: List<List<Int>>): Int {
    return pagesList
        .filter { !inCorrectOrder(it, sortRules) }
        .map { sortByRules(it, sortRules) }
        .sumOf { it.middlePage() }
}

fun sortByRules(pages: List<Int>, rules: Map<Int, List<Int>>): List<Int> {
    return pages.sortedWith { a, b -> if (rules[a]?.contains(b) == true) 1 else -1 }
}

fun getRulesMap(input: List<String>): Map<Int, List<Int>> {
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

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
    val input =  File("input.txt").readLines()

    val sortRules = getRulesMap(input)
    val pagesList = getPagesList(input)

    println("Part 1: ${solvePart1(sortRules, pagesList)}")
    println("Part 2: ${solvePart2(sortRules, pagesList)}")
}
