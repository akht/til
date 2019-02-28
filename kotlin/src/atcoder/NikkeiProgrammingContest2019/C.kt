package atcoder.NikkeiProgrammingContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xs =(1..n).map { readLine()!!.split(" ").map { it.toLong() } }
                                .sortedByDescending { it[0] + it[1] }

    var ans = 0L
    for (i in 0 until n) {
        if (i % 2 == 0) {
            ans += xs[i][0]
        } else {
            ans -= xs[i][1]
        }
    }
    println(ans)
}