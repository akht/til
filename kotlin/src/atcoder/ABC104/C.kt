package atcoder.ABC104

fun main(args: Array<String>) {
    val (D, G) = readLine()!!.split(" ").map { it.toInt() }
    val pc = (1..D).map { readLine()!!.split(" ").map { it.toInt() } }

    // ボーナス制度がなければ、点数の高い方から解いていけば良いが
    // ボーナスの有無によっては点数が低い問題を解いた方が得な場合がある。
    // なので、どのボーナスをとるか(=どの問題を全完するか)を中心に考える。
    // 全完する問題をbit全探索する。

    var ans = Int.MAX_VALUE
    // bit=どの問題を全完するか
    for (bit in 0 until (1 shl D)) {
        var count = 0
        var sum = 0L
        for (i in 0 until D) {
            if (bit and (1 shl i) != 0) {
                sum += 100 * (i+1) * pc[i][0] + pc[i][1]
                count += pc[i][0]
            }
        }
        if (G <= sum) {
            ans = Math.min(ans, count)
        } else {
            for (i in D - 1 downTo 0) {
                if (bit and (1 shl i) != 0) {
                    continue
                } else {
                    for (j in 0 until pc[i][0]) {
                        if (G <= sum) {
                            break
                        }
                        count++
                        sum += 100 * (i+1)
                    }
                }
            }
            ans = Math.min(ans, count)
        }
    }
    println(ans)
}