package day04

import countWordOccurrences
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day04KtTest {

    @Test
    fun countOccurrences() {
        val grid = arrayOf(
            "MMMSXXMASM",
            "MSAMXMSMSA",
            "AMXSXMAAMM",
            "MSAMASMSMX",
            "XMASAMXAMM",
            "XXAMMXXAMA",
            "SMSMSASXSS",
            "SAXAMASAAA",
            "MAMMMXMMMM",
            "MXMXAXMASX"
        )

        assertEquals(18, countWordOccurrences(grid))
    }
}
