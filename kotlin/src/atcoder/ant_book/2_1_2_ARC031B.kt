package atcoder.ant_book

fun main(args: Array<String>) {
    val grid = (1..10).map { readLine()!!.split("").drop(1).take(10).toMutableList() }

    // 各マスからすべてのマスを辿れるか調べて、辿れればひとつの島にできる
    // そのとき、スタート地点がすでに島なら最初からひとつの島だったということであり
    // スタート地点が島でなければ、そこを１マス埋め立てればひとつに島にすることができるということ
    // 各マスについて最大100マス調べるので100*100で求められる

    // 島がいくつあるか
    val islands = grid.flatMap { it }.filter { it == "o" }.count()

    for (y in 0 until 10) {
        for (x in 0 until 10) {
            val visited = Array(10) { Array(10) {false}}
            val original = grid[y][x]
            if (original != "o") {
                grid[y][x] = "o"
            }

            var count = dfs(grid, y, x, visited)

            if (original != "o") {
                count--
            }

            if (count == islands) {
                println("YES")
                return
            }
            grid[y][x] = original
        }
    }
    println("NO")
}

private fun dfs(grid: List<List<String>>, y: Int, x: Int, visited: Array<Array<Boolean>>): Int {
    if (!(y in 0 until 10 && x in 0 until 10)) {
        return 0
    }

    if (grid[y][x] == "x") {
        return 0
    }

    if (visited[y][x]) {
        return 0
    }

    visited[y][x] = true
    var count = 1

    val d = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)
    for ((dy, dx) in d) {
        count += dfs(grid, y + dy, x + dx, visited)
    }

    return count
}