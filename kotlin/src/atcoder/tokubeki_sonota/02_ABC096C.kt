package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map { it.toInt() }
    val grid = (1..h).map { readLine()!! }

    val d = listOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)

    for (y in (0 until h)) {
        for (x in (0 until w)) {
            if (grid[y][x] == '.') {
                continue
            }
            var found = false
            for ((dy, dx) in d) {
                val nextY = y + dy
                val nextX = x + dx
                if (nextY in 0 until h && nextX in 0 until w) {
                    if (grid[nextY][nextX] == '#') {
                        found = true
                        break
                    }
                }
            }
            if (!found) {
                println("No")
                return
            }
        }
    }
    println("Yes")
}