package de.bdr.eval.day01

import java.io.File
import kotlin.math.abs

fun main() {
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

    val file = File("input.txt")
    println(file.absolutePath)
    file.readLines().forEach {
        val sp = it.split(Regex(" +"))
        list1.add(sp[0].toInt())
        list2.add(sp[1].toInt())
    }

    list1.sort()
    list2.sort()

    var dist = 0
    for (idx in list1.indices) {
        dist += abs(list1[idx] - list2[idx])
    }
    println("Part 1: $dist")

    val frequencies = list2.groupingBy { it }.eachCount()
    val similarityScore =list1.map {
        it * (frequencies[it] ?: 0)
    }.sum()

    println("Part 2: $similarityScore")
}
