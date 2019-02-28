package atcoder.ABC113

import java.text.DecimalFormat

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    var xs = mutableListOf<Triple<Long, Long, Long>>()
    for (i in 0 until M) {
        val l = readLine()!!.split(" ").map { it.toLong() }
        val t = Triple(i.toLong(), l[0], l[1])
        xs.add(t)
    }

    xs.sortBy { it.third }
    xs.sortBy { it.second }

    var fmt = DecimalFormat("000000")

    var ans = mutableListOf<Pair<Long, String>>()
    var pref = xs[0].second
    var count = 0
    for (t in xs) {
        if (pref == t.second) {
            count++
        } else {
            count = 1
            pref = t.second
        }
        var p = Pair(t.first, fmt.format(t.second) + fmt.format(count))
        ans.add(p)
    }

    ans.sortedBy { it.first }.forEach { println(it.second) }
}