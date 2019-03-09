package atcoder.ABC121

fun main(args: Array<String>) {
    var (n, m) = readLine()!!.split(" ").map { it.toLong() }
    val abs = (1..n).map {
        val x = readLine()!!.split(" ").map { it.toLong() }
        Pair(x[0], x[1])
    }.sortedBy { it.first }

    var ans = 0L
    for ((a, b) in abs) {
        if (b >= m) {
            ans += m * a
            break
        } else {
            m -= b
            ans += b * a
        }
    }
    println(ans)
}