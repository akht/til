package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val wvs = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }
    val w = readLine()!!.toInt()

    // 漸化式的なDP

    // dp[i][j]を、i番目までの品物から、重さの総和がj以下となるように選んだ時の、価値の総和の最大値とすると
    //   dp[0][j] = 0
    //   dp[i + 1][j]
    //           = dp[i][j], この品物が入らないとき
    //           = max(dp[i][j], dp[i][j - w[i]] + v[i]) 品物が入るとき

    val dp = Array(n + 1) { Array(10010) { 0 } }

    for (i in 0 until n) {
        for (j in 0..w) {
            val weight = wvs[i][0]
            val value = wvs[i][1]
            if (j < weight) {
                dp[i + 1][j] = dp[i][j]
            } else {
                dp[i + 1][j] = Math.max(dp[i][j], dp[i][j - weight] + value)
            }
        }
    }
    println(dp[n][w])
}

