package atcoder.WUPC2019

import java.util.*

private data class Point(val y: Int, val x: Int, val v: Int)

private var h = 0
private var w = 0

fun main(args: Array<String>) {

    
    // これWA



    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    h = a
    w = b

    var count5 = 0
    var max = 0
    var allzero = true
    var grid = (1..h).map {
        val l = readLine()!!.split(" ").map { it.toInt() }
        for (a in l) {
            if (a == 5) {
                count5++
            }
            max = Math.max(max, a)
            if (a != 0) {
                allzero = false
            }
        }
        l
    }

    if (allzero) {
        println("Yes 0")
        return
    }

    if (count5 == 0) {
        println("No")
        return
    }

    if (max == 5) {
        println("Yes 1")
        return
    }

    // 5nより大きいマスを含む連結成分の数が答え

    val uf = UnionFind(h * w)

    val queue = ArrayDeque<Point>()
    val visited = Array(h) { Array(w) {false} }

    val start = Point(0, 0, grid[0][0])
    queue.offerLast(start)
    visited[start.y][start.x] = true

    val d = listOf(0 to 1, 0 to -1, 1 to 0, -1 to 0)
    while (!queue.isEmpty()) {
        val now = queue.pollFirst()

        var children = mutableListOf<Point>()
        for ((dy, dx) in d) {
            val nextY = now.y + dy
            val nextX = now.x + dx
            if (!(nextY in 0 until h && nextX in 0 until w)) {
                continue
            }
            if (visited[nextY][nextX]) {
                continue
            }
            children.add(Point(nextY, nextX, grid[nextY][nextX]))
        }

        for (child in children) {
            if (child.v != 5) {
                val child_n = fromPoint(child)

                for ((dy, dx) in d) {
                    val nextY = child.y + dy
                    val nextX = child.x + dx
                    if (!(nextY in 0 until h && nextX in 0 until w)) {
                        continue
                    }
                    if (grid[nextY][nextX] == 5) {
                        continue
                    }

                    val n = fromPoint(Point(nextY, nextX, -1))
                    uf.merge(n, child_n)
                }
            }

            if (now.v != 5 && child.v != 5) {
                val now_n = fromPoint(now)
                val child_n = fromPoint(child)
                uf.merge(now_n,  child_n)
            }

            visited[child.y][child.x] = true
            queue.offerLast(child)
        }
    }

    // 連結成分のインデックス
    val rootIndices = uf.rootIndices().filter {
        val p = toPoint(it)
        grid[p.y][p.x] != 5
    }

    var ans = 0
    for (rootIndex in rootIndices) {
        var maxCount = 0
        for (i in 0 until h * w) {
            if (uf.isSame(rootIndex, i)) {
                val p = toPoint(i)
                var v = grid[p.y][p.x]

                var count = when (v) {
                    9 -> 3
                    8 -> 2
                    7 -> 1
                    6 -> 1
                    else -> 0
                }
                maxCount = Math.max(maxCount, count)
            }
        }
        ans += maxCount
    }

    println("Yes ${ans + 1}")
}

// 座標をUnionFind用のインデックスに変換
private fun fromPoint(p: Point): Int {
    val y = p.y
    val x = p.x
    return w * y + x
}

private fun toPoint(n: Int): Point {
    return Point(n / w, n % w, -1)
}

private class UnionFind(n: Int) {
    val parent = Array(n) { -1 }

    fun root(x: Int): Int {
        return if (parent[x] < 0) {
            x
        } else {
            parent[x] = root(parent[x])
            parent[x]
        }
    }

    fun isSame(x: Int, y: Int): Boolean {
        return root(x) == root(y)
    }

    fun merge(x: Int, y: Int): Boolean {
        var xRoot = root(x)
        var yRoot = root(y)
        if (xRoot == yRoot) {
            return false
        }

        // merge technique
        if (parent[xRoot] > parent[yRoot]) {
            val tmp = yRoot
            yRoot = xRoot
            xRoot = tmp
        }

        parent[xRoot] += parent[yRoot];
        parent[yRoot] = xRoot
        return true
    }

    fun size(x: Int): Int {
        return -parent[root(x)]
    }

    fun rootIndices(): List<Int> {
        val res = mutableListOf<Int>()
        for ((i, p) in parent.withIndex()) {
            if (p < 0) {
                res.add(i)
            }
        }
        return res
    }
}