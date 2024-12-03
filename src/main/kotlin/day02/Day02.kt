package day02

import java.io.File
import kotlin.math.abs

fun main() {
    val input = File("input.txt")
    println(input.absolutePath)
    val safeReports = input.readLines()
        .filter { isSafe(it) }
        .toList()

    println("Part 1: ${safeReports.size}")

}

fun isSafe(report: String): Boolean {
    val split = report.split(" ")
        .map { it.toInt() }
        .toList()

    val asc = split[0] < split[1]
    for (i in 0 until split.size - 1) {
        if (asc && split[i] > split[i + 1]) {
            return false
        } else if (!asc && split[i] < split[i + 1]) {
            return false
        }
        val dist = abs(split[i] - split[i+1])
        if (dist < 1 || dist > 3) {
            return false
        }
    }
    return true


}
