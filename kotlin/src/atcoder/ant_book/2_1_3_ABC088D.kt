package atcoder.ant_book

import java.util.*

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val grid = (1..h).map { readLine()!! }

    // よりたくさん黒く塗ればスコアが上がるわけなので、けぬす君には最短経路を通ってもらう
    // 最短経路を通ったときのマス以外は黒く濡れるので、
    // (全ての白マス数) - (最短経路のマス数)が答えになる

    // 白マスの数
    val numOfWhite = grid.map { it.filter { it == '.' }.count() }.sum()

    data class Point(val y: Int, val x: Int, var dist: Int)

    val queue = ArrayDeque<Point>()
    val visited = Array(h) { Array(w) {false}}

    val start = Point(0, 0, 0)
    queue.offerLast(start)
    visited[start.y][start.x] = true

    val d = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    while (queue.isNotEmpty()) {
        val now = queue.pollFirst()

        val children = mutableListOf<Point>()
        for ((dy, dx) in d) {
            val nextY = now.y + dy
            val nextX = now.x + dx
            if (!(nextY in 0 until h && nextX in 0 until w)) {
                continue
            }
            if (grid[nextY][nextX] == '#') {
                continue
            }
            if (visited[nextY][nextX]) {
                continue
            }

            val child = Point(nextY, nextX, now.dist + 1)
            children.add(child)
        }

        for (child in children) {
            if (child.y == (h - 1) && child.x == (w - 1)) {
                val masu = child.dist + 1
                println(numOfWhite - masu)
                return
            }

            visited[child.y][child.x] = true
            queue.offerLast(child)
        }
    }

    println(-1)
}