package atcoder.ABC122

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val mod = 1000000007

    val dp = Array(n + 1) { Array(4) { Array(4) { Array(4) { 0 } } } }
    dp[0][3][3][3] = 1

    // A = 0, G = 1, C = 2, T = 3と対応づける
    for (len in 0 until n) {
        for (c1 in 0..3) {  // 最後から1文字目
            for (c2 in 0..3) {  // 最後から2文字目
                for (c3 in 0..3) {  // 最後から3文字目
                    if (dp[len][c1][c2][c3] == 0) {
                        continue
                    }
                    // 新しく末尾に追加する文字x
                    for (x in 0..3) {
                        // 5つのNGパターン
                        val ng1 =            c2 == 0 && c1 == 1 && x == 2  // ?AGC
                        val ng2 =            c2 == 1 && c1 == 0 && x == 2  // ?GAC
                        val ng3 =            c2 == 0 && c1 == 2 && x == 1  // ?ACG
                        val ng4 = c3 == 0            && c1 == 1 && x == 2  // A?GC
                        val ng5 = c3 == 0 && c2 == 1            && x == 2  // AG?C
                        if (ng1 || ng2 || ng3 || ng4 || ng5) {
                            continue
                        }

                        dp[len + 1][x][c1][c2] += dp[len][c1][c2][c3]
                        dp[len + 1][x][c1][c2] %= mod
                    }
                }
            }
        }
    }

    var ans = 0
    for (c1 in 0..3) {
        for (c2 in 0..3) {
            for (c3 in 0..3) {
                ans += dp[n][c1][c2][c3]
                ans %= mod
            }
        }
    }
    println(ans)
}