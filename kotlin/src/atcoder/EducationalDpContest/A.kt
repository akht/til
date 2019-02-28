package atcoder.EducationalDpContest

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val hs = readLine()!!.split(" ").map { it.toInt() }

    val inf = 1L shl 60

    // dp[i]: カエルが足場iへと移動するのに必要な最小コスト
    val dp = Array(n) {inf}
    dp[0] = 0

    for (i in 1 until n) {
        // i番目の足場行く方法は２通りある
        // i-1番目から来る場合と、i-2番目から来る場合がある
        // 二つとも計算してみて小さい方でDPテーブルを更新する

        dp[i] = Math.min(dp[i], dp[i-1] + Math.abs(hs[i] - hs[i-1]))
        if (i > 1) {
            dp[i] = Math.min(dp[i], dp[i-2] + Math.abs(hs[i] - hs[i-2]))
        }
    }
    println(dp[n-1])
}
