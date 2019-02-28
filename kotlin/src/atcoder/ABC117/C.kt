package atcoder.ABC117

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val xs = readLine()!!.split(" ").map { it.toLong() }.sorted()

    val dist = mutableListOf<Long>()
    for (i in 0 until xs.size - 1) {
        val d = Math.abs(xs[i] - xs[i + 1])
        dist.add(d)
    }

    val ans = dist.sortedDescending().drop(n - 1).sum()
    println(ans)
}