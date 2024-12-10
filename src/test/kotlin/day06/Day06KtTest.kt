package day06

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06KtTest {

    val input = """
        ....#.....
        .........#
        ..........
        ..#.......
        .......#..
        ..........
        .#..^.....
        ........#.
        #.........
        ......#...
    """.trimIndent().split("\n")

    @Test
    fun findStartPosition() {
        assertEquals(Pos(6, 4), findStartPosition(input.toTypedArray()))
    }

    @Test
    fun part1() {
        var result = solvePart1(input.toTypedArray())
        assertEquals(41, result)
    }
}
