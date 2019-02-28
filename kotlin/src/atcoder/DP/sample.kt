package atcoder.DP

import java.util.*

fun main(args: Array<String>) {
// n個の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] が与えられる。
// これらの整数から何個かの整数を選んで総和をとったときの、総和の最大値を求めよ。
// また、何も選ばない場合の総和は 0 であるものとする。
//
// 【制約】
//  ・1≤n≤100001≤n≤10000
//  ・−1000≤a[i]≤1000−1000≤a[i]≤1000

    // まずはDPする必要がないほど簡単な問題をDPでやってみて感覚を掴む
    // (この問題は、正の整数を全て選べばいいことは自明)


    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toInt() }

    // dp[i]: i番目のまでの整数を選んだ時の、総和の最大値
    val dp = Array(n + 1) {0}
    dp[0] = 0

    for (i in 0 until n) {
        val value = a[i]
        dp[i + 1] = Math.max(dp[i], dp[i] + value)
    }

    println(dp[n])
}