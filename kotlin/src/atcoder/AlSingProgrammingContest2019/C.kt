package atcoder.AlSingProgrammingContest2019

import java.util.*

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val hs = (1..h).map { readLine()!!.split("").drop(1).take(w) }


    val starts = mutableListOf<Point>()
    for (hh in (0 until h)) {
        for (ww in (0 until w)) {
            if (hs[hh][ww] == "#") {
                starts.add(Point(hh, ww, "#", null))
            }
        }
    }


    val points = mutableMapOf<Point, MutableList<Point>>()

    // キュー
    val queue = ArrayDeque<Point>()
    val moveY = arrayOf(1, 0, -1,  0)
    val moveX = arrayOf(0, 1,  0, -1)

    var visited = Array(h) { Array(w) {false} }

    for (b in starts) {
        queue.offerLast(b)
        visited[b.y][b.x] = true

        while (!queue.isEmpty()) {
            val p = queue.pollFirst()!!

            val children = mutableListOf<Point>()
            for (i in (0..3)) {
                val nextY = p.y + moveY[i]
                val nextX = p.x + moveX[i]
                if (nextY in 0 until h && nextX in 0 until w) {
                    val nextColor = hs[nextY][nextX]
                    if (p.color != nextColor) {
                        if (!visited[nextY][nextX]) {
                            val child = Point(nextY, nextX, nextColor, b)
                            children.add(child)
                        }
                    }
                }
            }

            for (child in children) {
                visited[child.y][child.x] = true
                queue.offerLast(child)

                if (child.color == "#") {
                    continue
                }

                if (points[child.parent!!] != null) {
                    val list = points[child.parent]!!
                    list.add(child)
                    points[child.parent] = list
                } else {
                    val list = mutableListOf(child)
                    points[child.parent] = list
                }
            }
        }

        visited = Array(h) { Array(w) {false} }
    }

    val ans = points.map { it.value.size }.sum()
    println(ans)
}

data class Point(val y: Int, val x: Int, val color: String, val parent: Point?)
