import java.io.File

fun main() {
    var input = File("input.txt").readLines().joinToString("")
    var sum = calc(input)

    println("Part 1: $sum")

    // !! need to use .*? with the question mark, to make the regex non-greedy (or "lazy")
    // so it wouldn't match do()'s in between ("don't ... do() ... do()") !!
    input = input.replace(Regex("""don't\(\).*?do\(\)"""), "")
    sum = calc(input)

    println("Part 2: $sum")
}

val regexMul = Regex("""mul\((\d{1,3}),(\d{1,3})\)""")

fun calc(input: String): Int {
    return regexMul.findAll(input).map {
        val a = it.groups[1]!!.value.toInt()
        val b = it.groups[2]!!.value.toInt()
        a * b
    }.sum()
}
