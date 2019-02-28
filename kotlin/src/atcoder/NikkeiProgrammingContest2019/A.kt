package atcoder.NikkeiProgrammingContest2019

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(" ").map { it.toInt() }
    val max = Math.min(a, b)
    val min = Math.max(0, a + b - n)
    println("$max $min")
}