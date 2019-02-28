package atcoder.DP

fun main(args: Array<String>) {
// n個の品物があり、i番目の品物のそれぞれ重さと価値が
// weight[i],value[i]weight[i],value[i] となっている
// (i=0,1,...,n−1i=0,1,...,n−1)。
// これらの品物から重さの総和が WW を超えないように選んだときの、価値の総和の最大値を求めよ。

    val n = readLine()!!.toInt()
    val limitW = readLine()!!.toInt()
    val wv = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }

    // dp[i]だけだと重さがWを超えないように、という情報が足りないので添字を追加する
    // dp[i][w]: i-1番目の品物の中から重さがwを超えないように選んだ時の、価値の総和の最大値

    // ※重さがwを超えないように〜ってのがわかりづらいが、要するに容量がwのとき、と考えればいい

    val dp = Array(110) { Array(10010) {0} }

    for (i in 0 until n) {
        for (w in 0..limitW) {
            val weight = wv[i][0]
            val value = wv[i][1]
            if (w >= weight) {
                dp[i+1][w] = Math.max(dp[i][w], dp[i][w - weight] + value)
            } else {
                dp[i+1][w] = dp[i][w]
            }
        }
    }

    println(dp[n][limitW])
}