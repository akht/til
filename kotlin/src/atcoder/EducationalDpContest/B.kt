package atcoder.EducationalDpContest

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val hs = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    val inf = 1L shl 60
    val dp = Array(n) {inf}
    dp[0] = 0

    for (i in 0 until n) {
        var j = 1
        while (j <= k && i + j < n) {
            dp[i + j] = Math.min(dp[i + j], dp[i] + Math.abs(hs[i + j] - hs[i]))
            j++
        }
    }
    println(dp[n - 1])
}