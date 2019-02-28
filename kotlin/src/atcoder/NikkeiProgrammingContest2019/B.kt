package atcoder.NikkeiProgrammingContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!
    val b = readLine()!!
    val c = readLine()!!

    var ans = (0 until n).map { listOf(a[it], b[it], c[it]).distinct().size - 1 }.sum()
    println(ans)
}