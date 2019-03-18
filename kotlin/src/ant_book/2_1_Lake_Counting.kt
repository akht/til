package ant_book

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val grid = (1..n).map { readLine()!!.toMutableList() }

    // 再帰でDFSして水たまりをカウントする
    // カウントするときに、一度訪れた水たまりを管理する代わりに「W」を「.」に置き換えてしまう
    // 左上からdfsして、「W」が見つかるたびにdfsで置き換えておく
    // dfsするたびに8近傍でつながっている水たまりが塗りつぶされるので、つながっていないものだけが残る
    // よって左上から右下まで何回「W」が出現するかを数えればよい

    var count = 0
    for (h in 0 until n) {
        for (w in 0 until m) {
            if (grid[h][w] == 'W') {
                dfs(grid, n, m, h, w)
                count++
            }
        }
    }
    println(count)
}

// 再帰でのDFS
// 8近傍を再帰で行けるとこまで塗りつぶす
private fun dfs(grid: List<MutableList<Char>>, n: Int, m: Int, y: Int, x: Int) {
    // Wを置き換える
    grid[y][x] = '.'

    val d = listOf(1 to 0, 1 to 1, 0 to 1, -1 to 0, -1 to -1, 0 to -1, 1 to -1, -1 to 1)

    for ((dy, dx) in d) {
        val nextY = y + dy
        val nextX = x + dx
        if (!(nextY in 0 until n && nextX in 0 until m)) {
            continue
        }
        if (grid[nextY][nextX] == 'W') {
            dfs(grid, n, m, nextY, nextX)
        }
    }
}
