package atcoder.ABC113

fun main(args: Array<String>) {
    val (N, M) = readLine()!!.split(" ").map { it.toInt() }

    var xs = (0 until M).map { i ->
        val l = readLine()!!.split(" ").map { it.toInt() }
        Triple(i, l[0], l[1])
    }.sortedBy { it.third }

    val memo = Array(N) { 0 }
    val ans = Array(M) { "" }
    for (city in xs) {
        val p = city.second
        val n = ++memo[p - 1]
        ans[city.first] = city.second.toString().padStart(6, '0') + n.toString().padStart(6, '0')
    }

    ans.forEach { println(it) }
}