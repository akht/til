package atcoder.AtCoderTypicalContest001

import java.util.*


/**
 * 再帰を使った深さ優先探索 その2(全探索タイプ)
 *
 * 全探索タイプはbfsでも実装できる(結局は全探索なので)
 */

private var h = 0
private var w = 0
private var board = listOf<List<String>>()
private var visited = arrayOf(arrayOf(false))


fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    h = a
    w = b
    board = (1..h).map { readLine()!!.split("").drop(1).take(w) }

    var start = Point(-1, -1)
    var goal = Point(-1, -1)
    for ((y, line) in board.withIndex()) {
        for ((x, s) in line.withIndex()) {
            if (s == "s") {
                start = Point(y, x)
            }
            if (s == "g") {
                goal = Point(y, x)
            }
        }
    }

    visited = Array(h) { Array(w) {false} }

    // 深さ優先探索で全ての到達可能なマスを埋める
    dfs(start.y, start.x)

    if (visited[goal.y][goal.x]) {
        // ゴール地点がvisited == trueになっていれば、
        // つまり到達できたということなのでYes
        println("Yes")
    } else {
        println("No")
    }

}

// 深さ優先探索(再帰)
// 値を返さないタイプのdfs(つまり全探索する)
// 全てのマスを訪れて、最後にゴールの位置のマスがvisited == trueになっていれば辿り着けることがわかる
// bfsでも書けるが、再帰でいけるdfsの方がシンプルに書ける
private fun dfs(y: Int, x: Int) {
    if ( ! (y in (0 until h) && x in (0 until w)) ) {
        return
    }
    if (board[y][x] == "#") {
        return
    }
    if (visited[y][x]) {
        return
    }

    visited[y][x] = true

    val dy = arrayOf(-1, 1,  0, 0)
    val dx = arrayOf(0,  0, -1, 1)

    for (i in (0..3)) {
        dfs(y + dy[i], x + dx[i])
    }

    // ↓のように書いてもいい(上下左右4方向)
//    dfs(y - 1, x , h, w, board, visited)
//    dfs(y + 1, x , h, w, board, visited)
//    dfs(y, x + 1, h, w, board, visited)
//    dfs(y, x - 1, h, w, board, visited)
}