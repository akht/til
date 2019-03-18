package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }
    val k = readLine()!!.toInt()

    if (dfs(a, 0, 0, k)) {
        println("Yes")
    } else {
        println("No")
    }
}

// 再帰でのDFS
private fun dfs(list: List<Int>, i: Int, sum: Int, k: Int): Boolean {
    if (i == list.size) {
        return sum == k
    }

    if (dfs(list, i + 1, sum, k)) {
        return true
    }

    if (dfs(list, i + 1, sum + list[i], k)) {
        return true
    }

    return false
}