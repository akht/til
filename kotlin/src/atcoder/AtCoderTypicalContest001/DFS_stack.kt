package atcoder.AtCoderTypicalContest001

import java.util.*


/**
 * スタックを使った深さ優先探索
 */


data class Point(val y: Int, val x: Int)

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val board = (1..h).map { readLine()!!.split("").drop(1).take(w) }

    var start = Point(-1, -1)
    for ((y, line) in board.withIndex()) {
        for ((x, s) in line.withIndex()) {
            if (s == "s") {
                start = Point(y, x)
            }
        }
    }

    val visited = Array(h) { Array(w) {false} }
    val stack = ArrayDeque<Point>()

    stack.offerFirst(start)
    visited[start.y][start.x] = true

    val dy = arrayOf(0, 1,  0, -1)
    val dx = arrayOf(1, 0, -1,  0)

    while (!stack.isEmpty()) {
        val now = stack.pollFirst()

        // 隣接するマスを取得
        val children = mutableListOf<Point>()
        for (i in (0..3)) {
            val nextY = now.y + dy[i]
            val nextX = now.x + dx[i]
            if (nextY in (0 until h) && nextX in (0 until w)) {
                if (board[nextY][nextX] != "#" && !visited[nextY][nextX]) {

                    var child = Point(nextY, nextX)
                    children.add(child)
                }
            }
        }

        // 隣接するマスに対する操作
        for (child in children) {
            visited[child.y][child.x] = true

            if (board[child.y][child.x] == "g") {
                println("Yes")
                return
            }
            stack.offerFirst(child)
        }
    }

    println("No")
}
