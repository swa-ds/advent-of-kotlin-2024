package day04

import countWordOccurrences
import countXmasOccurrences
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day04KtTest {

    val input = arrayOf(
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

    @Test
    fun countWordOccurrences() {
        assertEquals(18, countWordOccurrences(input))
    }

    @Test
    fun countXmasOccurrences() {
        assertEquals(9, countXmasOccurrences(input))
    }
}
