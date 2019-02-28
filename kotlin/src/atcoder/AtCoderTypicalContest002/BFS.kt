package atcoder.AtCoderTypicalContest002

import java.util.*

private var r = -1
private var c = -1
private var sy = -1
private var sx = -1
private var gy = -1
private var gx = -1
private var maze = listOf<List<String>>()

data class Point(val y: Int, val x: Int, var distance: Int)

fun main(args: Array<String>) {
    var (x, y) = readLine()!!.split(" ").map { it.toInt() }
    r = x
    c = y
    var (xx, yy) = readLine()!!.split(" ").map { it.toInt() }
    sy = xx - 1
    sx = yy - 1
    var (xxx, yyy) = readLine()!!.split(" ").map { it.toInt() }
    gy = xxx - 1
    gx = yyy - 1

    maze = (1..r).map { readLine()!!.split("").drop(1).take(c) }

    println(bfs())
}

fun bfs(): Int {
    val queue = ArrayDeque<Point>()
    val visited = Array(r) { Array(c) {false} }

    val start = Point(sy, sx, 0)
    queue.offerLast(start)
    visited[start.y][start.x] = true

    val dy = listOf(1, -1, 0,  0)
    val dx = listOf(0,  0, 1, -1)

    while (!queue.isEmpty()) {
        val now = queue.pollFirst()

        var children = (0..3).map {
            Point(now.y + dy[it], now.x + dx[it], now.distance + 1)
        }.filter {
            it.y in (0 until r) && it.x in (0 until c)
            &&
            maze[it.y][it.x] == "."
            &&
            !visited[it.y][it.x]
        }.toList()

        for (child in children) {
            if (child.y == gy && child.x == gx) {
                return child.distance
            }

            visited[child.y][child.x] = true
            queue.offerLast(child)
        }
    }

    return -1
}