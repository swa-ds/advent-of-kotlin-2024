package day02

import java.io.File
import kotlin.math.abs

fun main() {
    val input = File("input.txt")
    val safeReports1 = input.readLines()
        .filter { isSafe(it) }
        .toList()

    println("Part 1: ${safeReports1.size}")

    val safeReports2 = input.readLines()
        .filter { isSafe2(it) }
        .toList()

    println("Part 2: ${safeReports2.size}")
}

fun isSafe(report: String): Boolean {
    val ints = toIntsList(report)

    return isSafe(ints)
}

private fun isSafe(ints: List<Int>): Boolean {
    val asc = ints[0] < ints[1]
    for (i in 0 until ints.size - 1) {
        if (asc && ints[i] > ints[i + 1]) {
            return false
        } else if (!asc && ints[i] < ints[i + 1]) {
            return false
        }
        val dist = abs(ints[i] - ints[i + 1])
        if (dist < 1 || dist > 3) {
            return false
        }
    }
    return true
}

fun isSafe2(report: String): Boolean {
    if (isSafe(report)) {
        return true
    }
    val ints = toIntsList(report)
    for (i in ints.indices) {
        val mInts = ints.toMutableList()
        mInts.removeAt(i)
        if (isSafe(mInts)) {
            return true
        }
    }
    return false
}

private fun toIntsList(report: String): List<Int> {
    val split = report.split(" ")
        .map { it.toInt() }
        .toList()
    return split
}
