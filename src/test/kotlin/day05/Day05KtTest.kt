package day05

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day05KtTest {
    private val input = """
47|53
97|13
97|61
97|47
75|29
61|13
75|53
29|13
97|29
53|29
61|53
97|53
61|29
47|13
75|47
97|75
47|61
75|61
47|29
75|13
53|13

75,47,61,53,29
97,61,53,29,13
75,29,13
75,97,47,61,53
61,13,29
97,13,75,29,47
    """.trimIndent()
        .split("\n")

    @Test
    fun part1() {
        assertEquals(143, calculateMiddlePagesSum(input))
    }

    @Test
    fun getPagesList() {
        val pagesList = getPagesList(input)
        val exp = listOf(
            listOf(75,47,61,53,29),
            listOf(97,61,53,29,13),
            listOf(75,29,13),
            listOf(75,97,47,61,53),
            listOf(61,13,29),
            listOf(97,13,75,29,47),
        )
        assertEquals(exp, pagesList)
    }

    @Test
    fun middlePage() {
        assertEquals(2, getMiddlePage(listOf(1, 2, 3)))
        assertEquals(3, getMiddlePage(listOf(1, 2, 3, 4, 5)))
    }
}
