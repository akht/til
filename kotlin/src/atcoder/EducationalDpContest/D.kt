package atcoder.EducationalDpContest

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(" ").map { it.toInt() }
    val wv = (1..n).map { readLine()!!.split(" ").map { it.toLong() } }

    // まず試しに
    // dp[i]: i-1番目までの品物から重さがWを超えないように選んだ時の、価値の総和の最大値
    // としてみる
    // しかしこれだと、詰まってしまう
    // dp[i]からdp[i + 1]への遷移を考えるときに、dp[i]に対して品物を加えるか加えないかを考えるわけだが
    // 加えたときに重さがWを超えてしまうのかどうかわからないという問題がおこる
    // そこで次のようにDPテーブルを定義する
    // dp[i][sum_w]: i-1番目までの品物から重さがsum_wを超えないように選んだ時の、価値の総和の最大値
    // そしてdp[i][sum_w]が求まっている状態で、dp[i+1][sum_w]を更新していくことを考える
    // 品物を選ぶ時と選ばないときに場合分けして考えると、
    // 1.選ぶとき
    // 選んだとこで価値v[i]が加算され、ナップサックの容量がw[i]減るので
    // dp[i+1][sum_w] = max(dp[i+1][sum_w], dp[i][sum_w - w[i]] + v[i])
    // 2.選ばないとき
    // 価値も重さを変動しないので
    // dp[i+1][sum_w] = max(dp[i+1][sum_w], dp[i][sum_w])
    // と更新していく

    val dp = Array(110) { Array(100100) { 0L } }

    for (i in 0 until n) {
        for (sum_w in 0..w) {
            // この品物の重さ
            val weight = wv[i][0].toInt()
            // この品物の価値
            val value = wv[i][1]

            // i番目の品物を選ぶ場合
            if (sum_w - weight >= 0) {
                dp[i+1][sum_w] = Math.max(dp[i+1][sum_w], dp[i][sum_w - weight] + value)
            }

            // i番目の品物を選ばない場合
            dp[i+1][sum_w] = Math.max(dp[i+1][sum_w], dp[i][sum_w])
        }
    }

    println(dp[n][w])
}