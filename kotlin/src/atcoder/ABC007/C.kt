package atcoder.ABC007

import java.util.*

fun main(args: Array<String>) {
    val (R, C) = readLine()!!.split(" ").map { it.toInt() }
    val (sy, sx) = readLine()!!.split(" ").map { it.toInt() - 1 }
    val (gy, gx) = readLine()!!.split(" ").map { it.toInt() - 1 }

    val maze = (1..R).map { readLine()!!.split("").drop(1) }


    // キュー
    var queue = ArrayDeque<Point>()

    // スタート地点をキューに追加
    var start = Point(sy, sx)
    queue.addLast(start)

    // 訪問管理用の配列
    var visited = Array(R) { Array(C) {0} }
    visited[sy][sx] = 1

    var moveY = arrayOf(1, 0, -1,  0)
    var moveX = arrayOf(0, 1,  0, -1)

    while (!queue.isEmpty()) {
        var now = queue.pollFirst()

        // 隣接する地点を取得
        var children = mutableListOf<Point>()
        for (i in (0..3)) {
            var nextY = now.y + moveY[i]
            var nextX = now.x + moveX[i]
            if (nextY in 0 until R && nextX in 0 until C) {
                var child = Point(nextY, nextX)
                child.distance = now.distance + 1

                if (maze[child.y][child.x] == "#") {
                    continue
                }
                if (visited[child.y][child.x] == 1) {
                    continue
                }

                // 未訪問なら加える
                children.add(child)
            }
        }


        for (child in children) {
            // ゴールなら距離を返す
            if (child.y == gy && child.x == gx) {
                println(child.distance)
                return
            }

            // 訪問済にする
            visited[child.y][child.x] = 1

            // キューに追加
            queue.addLast(child)
        }
    }
}

fun printMatrix(matrix: List<List<String>>) {
    matrix.map { it.joinToString(separator = " ") }.forEach { println(it) }
}

class Point(val y: Int, val x: Int) {
    var distance = 0
}