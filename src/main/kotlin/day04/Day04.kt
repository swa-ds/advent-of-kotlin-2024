import java.io.File

fun countWordOccurrences(grid: Array<String>): Int {
    val rows = grid.size
    val cols = grid[0].length
    val target = "XMAS"
    val directions = listOf(
        Pair(0, 1),  // Right
        Pair(1, 0),  // Down
        Pair(0, -1), // Left
        Pair(-1, 0), // Up
        Pair(1, 1),  // Down-right diagonal
        Pair(1, -1), // Down-left diagonal
        Pair(-1, 1), // Up-right diagonal
        Pair(-1, -1) // Up-left diagonal
    )

    fun isValid(x: Int, y: Int): Boolean = x in 0 until rows && y in 0 until cols

    fun checkDirection(x: Int, y: Int, dx: Int, dy: Int): Boolean {
        for (k in target.indices) {
            val nx = x + k * dx
            val ny = y + k * dy
            if (!isValid(nx, ny) || grid[nx][ny] != target[k]) return false
        }
        return true
    }

    var count = 0
    for (x in 0 until rows) {
        for (y in 0 until cols) {
            for ((dx, dy) in directions) {
                if (checkDirection(x, y, dx, dy)) {
                    count++
                }
            }
        }
    }
    return count
}

fun countXmasOccurrences(grid: Array<String>): Int {
    var occurrences = 0
    for (row in 1 until grid.size - 1) {
        for (col in 1 until grid[row].length - 1) {
            if (grid[row][col] == 'A' &&
                (grid[row-1][col-1] == 'M' && grid[row+1][col+1] == 'S'
                    || grid[row-1][col-1] == 'S' && grid[row+1][col+1] == 'M') &&
                (grid[row-1][col+1] == 'M' && grid[row+1][col-1] == 'S'
                        || grid[row-1][col+1] == 'S' && grid[row+1][col-1] == 'M')
                ) {
                    occurrences++
            }
        }
    }
    return occurrences
}

fun main() {
    val grid = File("input.txt").readLines().toTypedArray()

    println("Part 1: ${countWordOccurrences(grid)}")
    println("Part 2: ${countXmasOccurrences(grid)}")
}
