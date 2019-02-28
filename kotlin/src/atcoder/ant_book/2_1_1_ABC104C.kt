package atcoder.ant_book

fun main(args: Array<String>) {
    val (d, g) = readLine()!!.split(" ").map { it.toInt() }
    val pc = (1..d).map { readLine()!!.split(" ").map { it.toInt() } }

    // どのボーナスをとるかでbit全探索する
    // 足りない分は点数が高い問題からgreedy
    // ボーナスをとるまでもなく目的を達成できる場合は、ボーナスをとらない場合(=ビットが0)でカバーされる

    var ans = Int.MAX_VALUE
    for (bit in 0 until (1 shl d)) {
        var count = 0
        var sum = 0L
        for (no in 0 until d) {
            val numOfproblems = pc[no][0]
            val point = (no + 1) * 100
            val bonus = pc[no][1]
            if (1 and (bit shr no) == 1) {
                // ビットがたっていたらこの問題のボーナスをとる=すべて解く
                count += numOfproblems
                sum += point * numOfproblems + bonus
            }
        }

        if (g <= sum) {
            ans = Math.min(ans, count)
            continue
        }

        // ボーナスをとっても足りない場合は点数が高い問題からgreedyにとっていく
        for (no in d - 1 downTo 0) {
            var flg = false

            if (1 and (bit shr no) == 1) {
                // ビットが立っている問題はすでにすべてとっているので次へ
                continue
            }

            val numOfproblems = pc[no][0]
            val point = (no + 1) * 100
            for (i in 1..numOfproblems) {
                sum += point
                count++
                if (g <= sum) {
                    flg = true
                    break
                }
            }
            if (flg) {
                break
            }
        }
        ans = Math.min(ans, count)
    }
    println(ans)
}