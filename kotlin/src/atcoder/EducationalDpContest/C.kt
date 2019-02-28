package atcoder.EducationalDpContest

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val abc = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }

    // dp[i][j]: i日目までの活動履歴のうち、最終日であるi日目には活動jを選んだ時の、得られる幸福度の最大値
    //           活動jは、0=a, 1=b, 2=cとする
    //           i日目に3つの活動をやってみて、そのうちのmaxが求める答え

    val dp = Array(n + 1) { Array(3) { 0L } }

    for (i in 0 until n) {
        for (j in 0..2) {
            for (k in 0..2) {
                if (j == k) {
                    continue
                }
                dp[i + 1][k] = Math.max(dp[i + 1][k], dp[i][j] + abc[i][k])
            }
        }
    }

    var ans = 0L
    for (i in 0..2) {
        ans = Math.max(ans, dp[n][i])
    }
    println(ans)
}