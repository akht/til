package atcoder.ABC123

import java.util.*

fun main(args: Array<String>) {
    val (x, y, z, k) = readLine()!!.split(" ").map { it.toInt() }
    val aa = readLine()!!.split(" ").map { it.toLong() }.sortedDescending()
    val bb = readLine()!!.split(" ").map { it.toLong() }.sortedDescending()
    val cc = readLine()!!.split(" ").map { it.toLong() }.sortedDescending()

    data class Data(val choice: Triple<Int, Int, Int>, val sum: Long)

    // 最大の選び方
    val max = Data(Triple(0, 0, 0), aa[0] + bb[0] + cc[0])

    // 優先度付きキュー
    val priorityQueue = PriorityQueue<Data>(Comparator { o1, o2 -> if (o2.sum - o1.sum > 0) 1 else -1 })
    priorityQueue.offer(max)

    val memo = Array(x) { Array(y) { Array(z) { false } } }

    var count = 0
    while (count < k && priorityQueue.isNotEmpty()) {
        val t = priorityQueue.poll()
        println(t.sum)
        count++

        val a = t.choice.first
        val b = t.choice.second
        val c = t.choice.third
        val nextA = a + 1
        val nextB = b + 1
        val nextC = c + 1

        if (nextA < x && !memo[nextA][b][c]) {
            priorityQueue.offer(Data(Triple(nextA, b, c), aa[nextA] + bb[b] + cc[c]))
            memo[nextA][b][c] = true
        }
        if (nextB < x && !memo[a][nextB][c]) {
            priorityQueue.offer(Data(Triple(a, nextB, c), aa[a] + bb[nextB] + cc[c]))
            memo[a][nextB][c] = true
        }
        if (nextC < x && !memo[a][b][nextC]) {
            priorityQueue.offer(Data(Triple(a, b, nextC), aa[a] + bb[b] + cc[nextC]))
            memo[a][b][nextC] = true
        }
    }
}