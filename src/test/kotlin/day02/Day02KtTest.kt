package day02

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day02KtTest {

    @Test
    fun isSafe2() {
        assertTrue(isSafe2("7 6 4 2 1"))
        assertFalse(isSafe2("1 2 7 8 9"))
        assertFalse(isSafe2("9 7 6 2 1"))
        assertTrue(isSafe2("1 3 2 4 5"))
        assertTrue(isSafe2("8 6 4 4 1"))
        assertTrue(isSafe2("1 3 6 7 9"))
    }
}
