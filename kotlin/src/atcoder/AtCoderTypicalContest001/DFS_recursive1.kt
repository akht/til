package atcoder.AtCoderTypicalContest001

import java.util.*


/**
 * 再帰を使った深さ優先探索 その1(見つかった時点で抜けるタイプ)
 */

private var h = 0
private var w = 0
private var board = listOf<List<String>>()
private var visited = arrayOf(arrayOf(false))

fun main(args: Array<String>) {
    var (a, b) = readLine()!!.split(" ").map { it.toInt() }
    h = a
    w = b
    board = (1..h).map { readLine()!!.split("").drop(1).take(w) }

    var start = Point(-1, -1)
    for ((y, line) in board.withIndex()) {
        for ((x, s) in line.withIndex()) {
            if (s == "s") {
                start = Point(y, x)
            }
        }
    }

    visited = Array(h) { Array(w) {false} }

    if (dfs(start.y, start.x)) {
        println("Yes")
    } else {
        println("No")
    }

}

// 深さ優先探索(再帰)
// 値を返すタイプのdfs
// 隣接するマスで自身を呼び出してゴールにたどり着いた時点でtrueをリターンする
private fun dfs(y: Int, x: Int): Boolean {
    if ( ! (y in (0 until h) && x in (0 until w)) ) {
        return false
    }
    if (board[y][x] == "#") {
        return false
    }
    if (visited[y][x]) {
        return false
    }
    if (board[y][x] == "g") {
        return true
    }

    visited[y][x] = true

    val dy = arrayOf(-1, 1,  0, 0)
    val dx = arrayOf(0,  0, -1, 1)

    for (i in (0..3)) {
        if (dfs(y + dy[i], x + dx[i])) {
            return true
        }
    }

    return false
}