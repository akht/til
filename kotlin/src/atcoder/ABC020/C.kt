package atcoder.ABC020

import java.util.*

private var h = -1
private var w = -1
private var t = -1L
private var grid = listOf<String>()
private var sy = -1
private var sx = -1
private var gy = -1
private var gx = -1

data class Point(val y: Int, val x: Int, var cost: Long)

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }
    h = a.toInt()
    w = b.toInt()
    t = c
    grid = (1..h).map { readLine()!! }

    for ((y, line) in grid.withIndex()) {
        for ((x, char) in line.withIndex()) {
            if (char == 'S') {
                sy = y
                sx = x
            } else if (char == 'G') {
                gy = y
                gx = x
            }
        }
    }

    var ng = t + 1
    var ok = 0L
    while (Math.abs(ok - ng) > 1) {
        val mid = (ok + ng) / 2

        // costMemo[y][x]: その地点までのコストの最小値
        val costMemo = Array(h) { Array(w) {9999999999}}

        val queue = ArrayDeque<Point>()
        queue.offerLast(Point(sy, sx, 0))

        val d = listOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

        while (!queue.isEmpty()) {
            val now = queue.pollFirst()

            for ((dy, dx) in d) {
                val nextY = now.y + dy
                val nextX = now.x + dx
                if (!(nextY in 0 until h && nextX in 0 until w)) {
                    continue
                }

                val nextCost = if (grid[nextY][nextX] == '#') now.cost + mid else now.cost + 1
                if (nextCost < costMemo[nextY][nextX]) {
                    costMemo[nextY][nextX] = nextCost
                    queue.offerLast(Point(nextY, nextX, nextCost))
                }
            }
        }

        if (costMemo[gy][gx] <= t) {
            ok = mid
        } else {
            ng = mid
        }
    }
    println(ok)
}
