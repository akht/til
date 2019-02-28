package atcoder.ABC106

fun main(args: Array<String>) {
    val (n, m, q) = readLine()!!.split(" ").map(String::toInt)

    val lr = mutableListOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (l, r) = readLine()!!.split(" ").map(String::toInt)
        val pair = Pair(l, r)
        lr.add(pair)
    }

    val pq = mutableListOf<Pair<Int, Int>>()
    for (i in 1..q) {
        val (l, r) = readLine()!!.split(" ").map(String::toInt)
        val pair = Pair(l, r)
        pq.add(pair)
    }

    val memo = mutableMapOf<Pair<Int, Int>, Int>()

    for (q in pq) {
        if (memo.containsKey(q)) {
            println(memo[q])
            continue
        }

        var count = 0
        for (express in lr) {
            if (q.first <= express.first && express.second <= q.second) {
                count++
            }
        }
        println(count)
        memo[q] = count
    }
}