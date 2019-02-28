package atcoder.CADDI2018

fun main(args: Array<String>) {
    val (n, h, w) = readLine()!!.split(" ").map { it.toInt() }
    val xs = (1..n).map { readLine()!!.split(" ").map { it.toLong() } }

    val ans = xs.filter { h <= it[0] && w <= it[1] }.size
    println(ans)
}