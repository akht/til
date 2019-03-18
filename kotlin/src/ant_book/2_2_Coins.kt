package ant_book

fun main(args: Array<String>) {
    val coins = readLine()!!.split(" ").map { it.toLong() }
    var A = readLine()!!.toLong()

    // コインの金額
    val yen = listOf(1, 5, 10, 50, 100, 500)

    var ans = 0L
    for (i in yen.size - 1 downTo 0) {
        val count = Math.min(A / yen[i], coins[i])
        A -= count * yen[i]
        ans += count
    }
    println(ans)
}