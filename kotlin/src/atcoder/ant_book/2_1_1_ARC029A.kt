package atcoder.ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val tn = (1..n).map { readLine()!!.toInt() }

    // 各お肉をどちらのマシンで焼くかをbitで表現してbit全探索する

    var ans = Int.MAX_VALUE
    for (bit in 0 until (1 shl n)) {
        var a = 0
        var b = 0
        for (i in 0 until n) {
            if (1 and (bit shr i) == 1) {
                a += tn[i]
            } else {
                b += tn[i]
            }
        }
        ans = Math.min(ans, Math.max(a, b))
    }
    println(ans)
}