package atcoder.ant_book

import java.util.*

fun main(args: Array<String>) {
    val (r, c) = readLine()!!.split(" ").map { it.toInt() }
    var (sy, sx) = readLine()!!.split(" ").map { it.toInt() - 1 }
    var (gy, gx) = readLine()!!.split(" ").map { it.toInt() - 1 }
    val grid = (1..r).map { readLine()!! }

    data class Point(val y: Int, val x: Int, var dist: Int)

    val queue = ArrayDeque<Point>()
    val visited = Array(r) { Array(c) {false} }

    val start = Point(sy, sx, 0)
    queue.offerLast(start)
    visited[start.y][start.x] = true

    val d = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)

    while (queue.isNotEmpty()) {
        val now = queue.pollFirst()!!

        val children = mutableListOf<Point>()
        for ((dy, dx) in d) {
            val nextY = now.y + dy
            val nextX = now.x + dx

            if (!(nextY in 0 until r && nextX in 0 until c)) {
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
            if (child.y == gy && child.x == gx) {
                println(child.dist)
                return
            }

            visited[child.y][child.x] = true
            queue.offerLast(child)
        }

    }

}