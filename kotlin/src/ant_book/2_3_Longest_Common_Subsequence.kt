package ant_book

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    val t = readLine()!!

    // 最長共通部分列(Longest Common Subsequence, LCS)

    // LCS長を求めるとき
    // ふたつの文字列X, Yがあったときにi番目までとj番目までのLCS長、つまりXiとYjのLCS長が
    // より小さい文字列のLCS長から求められるのを利用する

    // ここがわかりやすい
    // http://d.hatena.ne.jp/naoya/20090328/1238251033

    // dp[i][j]を、s[0..j]とt[0..j]のLCS長とする
    val dp = Array(n + 1) { Array(m + 1) { 0 } }


    for (i in 0 until n) {
        for (j in 0 until m) {
            if (s[i] == t[j]) {
                // 次の文字が同じのときはLCS長は単純に+1
                dp[i + 1][j + 1] = dp[i][j] + 1
            } else {
                // 次の文字が異なるときは+1にならないので
                // 片方ずつ足された場合の長いほうを選ぶ
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j])
            }
        }
    }
    println(dp[n][m])
}