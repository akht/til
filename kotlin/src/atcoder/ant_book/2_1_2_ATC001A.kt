package atcoder.ant_book

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val grid = (1..h).map { readLine()!!.split("").drop(1).take(w) }

    data class Point(val y: Int, val x: Int)

    var start = Point(-1, -1)
    var goal = Point(-1, -1)

    for (y in 0 until h) {
        for (x in 0 until w) {
            if (grid[y][x] == "s") {
                start = Point(y, x)
            } else if (grid[y][x] == "g") {
                goal = Point(y, x)
            }
        }
    }

    val visited = Array(h) { Array(w) {false} }

    dfs(grid, start.y, start.x, visited, h, w)

    if (visited[goal.y][goal.x]) {
        println("Yes")
    } else {
        println("No")
    }
}

private fun dfs(grid: List<List<String>>, y: Int, x: Int, visited: Array<Array<Boolean>>, h: Int, w: Int) {
    if (!(y in 0 until h && x in 0 until w)) {
        return
    }

    if (grid[y][x] == "#") {
        return
    }

    if (visited[y][x]) {
        return
    }

    visited[y][x] = true

    val d = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)
    for ((dy, dx) in d) {
        dfs(grid, y + dy, x + dx, visited, h, w)
    }
}