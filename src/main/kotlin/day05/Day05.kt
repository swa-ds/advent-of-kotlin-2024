package day05

import java.io.File

private fun toIntsList(it: String) = it.split(",").map { it.toInt() }.toList()

fun calculateMiddlePagesSum(input: List<String>): Int {

    val rulesMap = getRulesMap(input)
    val pagesList = getPagesList(input)

    fun inCorrectOrder(pages: List<Int>): Boolean {
        if (pages.size <= 1) {
            return true
        }
        val first = pages.first()
        val rest = pages.subList(1, pages.size)
        for (p in rest) {
            if (rulesMap[p]?.contains(first) == true) {
                return false
            }
        }
        return inCorrectOrder(rest)
    }

    val sum = pagesList
        .filter { inCorrectOrder(it) }
        .map { getMiddlePage(it) }
        .sum()

    return sum
}

fun getMiddlePage(pages: List<Int>): Int {
//    println(pages)
    return pages[pages.size / 2]
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
