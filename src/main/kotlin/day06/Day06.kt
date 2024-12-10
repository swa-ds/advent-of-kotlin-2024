package day06

import java.io.File

data class Pos(val y: Int, val x: Int)

val directions = listOf(
    Pair(-1, 0), // Up
    Pair(0, 1),  // Right
    Pair(1, 0),  // Down
    Pair(0, -1), // Left
)

fun solvePart1(grid: Array<String>): Int {
    val rows = grid.size
    val cols = grid[0].length

    fun isValid(pos: Pos): Boolean = pos.x in 0 until cols && pos.y in 0 until rows

    var pos = findStartPosition(grid)
    var iDir = 0
    var dir = directions[iDir]

    val visited = mutableSetOf(pos)

    var nextPos = advance(pos, dir)
    while (isValid(nextPos)) {
        if (grid[nextPos.y][nextPos.x] == '#') {
            iDir++
            dir = directions[iDir % directions.size]
            continue
        }
        pos = nextPos
        visited.add(pos)
        nextPos = advance(pos, dir)
    }

    return visited.size
}

fun advance(pos: Pos, dir: Pair<Int, Int>): Pos {
    val (dy, dx) = dir
    return Pos(pos.y + dy, pos.x + dx)
}

fun findStartPosition(grid: Array<String>): Pos {
    for ((i, row) in grid.withIndex()) {
        if (row.contains('^')) {
            return Pos(i, row.indexOf('^'))
        }
    }
    throw IllegalArgumentException("Start position not found")
}

fun main() {
    val input = File("input.txt").readLines().toTypedArray()
    println("${solvePart1(input)}")
}
