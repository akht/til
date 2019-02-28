package atcoder.EducationalDpContest

fun main(args: Array<String>) {
    val (n, w) = readLine()!!.split(" ").map { it.toInt() }
    val wv = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }

    val inf = 10e9.toLong()
    val maxV = 100

    // dp[i][v]: i番目までの品物から価値がvを超えるように選んだ時の、重さの総和の最小値
    // dp[i][v]からdp[i+1][v]を考えると、
    // 次の品物を選ぶ時は、その品物の重さを足して超えなければいけない価値になればいい(制約を満たせばいい)
    // 次の品物の分だけ価値が増えるから、それを制約から引いた分(つまりdp[i][v - nextValue])の最小値があらかじめ求まって入ればいい
    // 次の品物を選ばない場合は、dp[i][v]と変わらない
    // ノートに3つの品物◯◯◯を描いて、dp[i][v]から次の◯を選ぶ時を考えてみればわかりやすい
    // vの制約(v以上になるように)を満たすためには、◯が持っている価値の分だけ二つの目の[]に足せるから
    // 次の◯の価値込みでvを満たすように考えるということ
    val dp = Array(n + 1) { Array(maxV + 1) { inf } }
    dp[0][0] = 0

    for (i in 0 until n) {
        for (v in 0..maxV) {
            val weight = wv[i][0]
            val value = wv[i][1]
            if (v >= value) {
                dp[i + 1][v] = Math.min(dp[i + 1][v], dp[i][v - value] + weight)
            }

            dp[i + 1][v] = Math.min(dp[i + 1][v], dp[i][v])
        }
    }

    var ans = 0
    for (v in 0..maxV) {
        if (dp[n][v] <= w) {
            ans = Math.max(ans, v)
        }
    }

    println(ans)
}