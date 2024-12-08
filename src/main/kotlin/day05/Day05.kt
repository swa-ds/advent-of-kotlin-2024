package day05

import java.io.File

private fun toIntsList(it: String) = it.split(",").map { it.toInt() }.toList()

fun calculateMiddlePagesSum(input: List<String>): Int {
    var sum = 0

    var map: MutableMap<Int, MutableList<Int>> = mutableMapOf()

    input.takeWhile { it.isNotEmpty() }
        .forEach {
            val split = it.split("|")
            map.getOrPut(split[0].toInt()) { mutableListOf() }.add(split[1].toInt())
        }
    println(map)

    val pagesList = input
        .filter { it.contains(",") }
        .map { toIntsList(it) }
    println(pagesList)

    return sum
}

fun main() {
    val input = File("input.txt").readLines()
    println("Part 1: ${calculateMiddlePagesSum(input)}")
}
