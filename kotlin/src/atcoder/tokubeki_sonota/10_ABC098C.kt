package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    dp()
}

fun dp() {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    val dp = Array(n) {3 * 10e5.toInt()}
    dp[0] = s.drop(1).filter { it == 'E' }.count()

    for (i in 1 until n) {
        if (s[i - 1] == 'E' && s[i] == 'E') {
            dp[i] = dp[i - 1] - 1
        } else if (s[i - 1] == 'W' && s[i] == 'W') {
            dp[i] = dp[i - 1] + 1
        } else {
            dp[i] = dp[i - 1]
        }
    }

    println(dp.min()!!)
}