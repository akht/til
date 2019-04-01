package atcoder.exawizards2019

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    val tds = (1..q).map { readLine()!!.split(" ") }


    fun simulate(pos: Int): Int {
        var now = pos
        for ((t, d) in tds) {
            if (s[now].toString() != t) {
                continue
            }
            if (d == "L") {
                now--
            } else {
                now++
            }
            if (now < 0) {
                return -1
            } else if (now >= n) {
                return 1
            }
        }
        return 0
    }


    var low = -1
    var high = n
    while (Math.abs(high - low) > 1) {
        val mid = (high + low) / 2
        if (simulate(mid) == -1) {
            low = mid
        } else {
            high = mid
        }
    }
    var left = high

    low = -1
    high = n
    while (Math.abs(high - low) > 1) {
        val mid = (high + low) / 2
        if (simulate(mid) == 1) {
            high = mid
        } else {
            low = mid
        }
    }
    val right = low

    println(right - left + 1)
}
