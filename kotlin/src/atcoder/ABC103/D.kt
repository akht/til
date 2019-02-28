package atcoder.ABC103

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val xs: MutableList<Pair<Int, Int>> = mutableListOf()
    for (i in 1..m) {
        val (a, b) = readLine()!!.split(" ").map(String::toInt)
        xs.add(Pair(a, b))
    }
    // 目的地で昇順に並べる
    xs.sortBy { it.second }

    var count = 0
    var prev = 0
    if (xs.isNotEmpty()) {
        count = 1
        prev = xs[0].second - 1
    }

    for (i in 1 until xs.size) {
        val pair = xs[i]
        if (pair.first <= prev) {
            continue
        }

        count++
        prev = pair.second - 1
    }

    println(count)
}