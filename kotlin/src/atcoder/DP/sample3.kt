package atcoder.DP

import java.util.*

fun main(args: Array<String>) {
// n個の正の整数 a[0],a[1],…,a[n−1]a[0],a[1],…,a[n−1] と正の整数Aが与えられる。
// これらの整数から何個かの整数を選んで総和がAになるようにすることが可能か判定せよ。
// 可能ならば "YES" と出力し、不可能ならば "NO" と出力せよ。

// 【制約】
// ・1≤n≤100
// ・1≤a[i]≤1000
// ・1≤A≤10000

    val (n, A) = readLine()!!.split(" ").map { it.toInt() }
    val an = readLine()!!.split(" ").map { it.toInt() }


    // 制約がn<=100なのでbit全探索はムリ(2^100かかる)

    val dp = Array(n + 1) { Array(A + 1) { false } }
    dp[0][0] = true

    for (i in 0 until n) {
        for (j in 0..A) {
            if (j -an[i] >= 0) {
                if (dp[i + 1][j - an[i]]) {
                    dp[i + 1][j] = true
                }
            }
            if (dp[i][j]) {
                dp[i + 1][j] = true
            }
        }
    }

    if (dp[n][A]) {
        println("YES")
    } else {
        println("NO")
    }
}