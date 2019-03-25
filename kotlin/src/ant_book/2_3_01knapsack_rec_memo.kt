package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val wvs = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }
    val w = readLine()!!.toInt()

    // 単純な選ぶ、選ばないを再帰でやると、O(2^N)かかる
    // rec(i, j)は引数が同じなら返り値も同じになるのでそれをメモすることで無駄な計算を省く

    // 計算結果を覚えておくためのメモ
    val dp = Array(110) { Array(110) { -1 }}

    fun rec(i: Int, j: Int): Int {
        // すでに調べたことがあればその結果を再利用
        if (dp[i][j] >= 0) {
            return dp[i][j]
        }

        // 停止条件
        if (i == n) {
            return 0
        }

        val (weight, value) = wvs[i]
        var res = 0
        if (j < weight) {
            // この品物は入らない
            res = rec(i + 1, j)
        } else {
            // この品物を入れる場合と入れない場合の両方を試す
            res = Math.max(
                    rec(i + 1, j),
                    rec(i + 1, j - weight) + value
            )
        }

        // メモに保存
        dp[i][j] = res

        return res
    }

    println(rec(0, w))
}

