package atcoder.ABC119

fun main(args: Array<String>) {
    val (n, a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    val ls = (1..n).map { readLine()!!.toInt() }

    val target = Triple(a, b, c)
    val start = Triple(0, 0, 0)

    println(rec(ls, n, 0, start, target))
}

fun rec(list: List<Int>, n: Int, i: Int, now: Triple<Int, Int, Int>, target: Triple<Int, Int, Int>): Int {
    val (a, b, c) = now

    if (i == n) {
        if (a == 0 || b == 0 || c == 0 ) {
            return 1 shl 29
        }
        return Math.abs(now.first - target.first) + Math.abs(now.second - target.second) + Math.abs(now.third - target.third)
    }

    var res = rec(list, n, i + 1, Triple(a, b, c), target)
    res = Math.min(res, rec(list, n, i + 1, Triple(a + list[i], b, c), target) + if (a == 0) 0 else 10)
    res = Math.min(res, rec(list, n, i + 1, Triple(a, b + list[i], c), target) + if (b == 0) 0 else 10)
    res = Math.min(res, rec(list, n, i + 1, Triple(a, b, c + list[i]), target) + if (c == 0) 0 else 10)

    return res
}