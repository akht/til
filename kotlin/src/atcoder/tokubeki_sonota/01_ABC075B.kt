package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val board = (1..h).map { readLine()!!.split("").drop(1).take(w).map { if (it == "#" ) it else "0" }.toMutableList() }

    val dy = listOf(-1, 1, 0,  0, -1, 1,  1, -1)
    val dx = listOf( 0, 0, 1, -1,  1, 1, -1, -1)

    for (i in 0 until h) {
        for (j in 0 until w) {
            if (board[i][j] == "#") {
                for (k in 0..7) {
                    val y = i + dy[k]
                    val x = j + dx[k]
                    if (y in 0 until h && x in 0 until w) {
                        if (board[y][x] != "#") {
                            board[y][x] = (board[y][x].toInt() + 1).toString()
                        }
                    }
                }
            }
        }
    }
    print(board)
}

fun <T> print(matrix: List<List<T>>) {
    matrix.forEach { println(it.joinToString("")) }
}