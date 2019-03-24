package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val wvs = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }
    val w = readLine()!!.toInt()

    // 単純な再帰で解く
    // i番目以降の品物から重さの総和がj以下となるように選ぶ時の価値の最大値を返す
    fun rec(i: Int, j: Int): Int {
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
        return res
    }

    println(rec(0, w))
}

