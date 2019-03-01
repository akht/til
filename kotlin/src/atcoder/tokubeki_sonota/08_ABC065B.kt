package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = (1..n).map { readLine()!!.toInt() - 1 }

    val visited = Array(n) { false }
    visited[0] = true
    var no = 0
    var ans = 0
    (0 until n).forEach {
        if (no == 1) {
            println(ans)
            return
        }
        val next = an[no]
        if (visited[next]) {
            println(-1)
            return
        }
        visited[next] = true
        ans++
        no = next
    }
    println(-1)
}