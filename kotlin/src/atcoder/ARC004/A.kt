package atcoder.ARC004

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xs = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }.map { Pair(it[0], it[1]) }


    fun d(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Double =
            Math.sqrt(
                  Math.pow((p1.first - p2.first).toDouble(), 2.0)
                + Math.pow((p1.second - p2.second).toDouble(), 2.0)
            )

    var ans = 0.0
    for ((i, p1) in xs.withIndex()) {
        for (j in (i until n)) {
            ans = Math.max(ans, d(p1, xs[j]))
        }
    }

    println(ans)
}