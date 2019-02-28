package atcoder.ARC029

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    var xs = (1..N).map { readLine()!!.toInt() }

    // 1 <= N <= 4なので単純にbit全探索する
    // 0と1で載せる肉焼き器を分けて、それらのmaxが結局かかる時間
    // あとは、それらの最小値が求める答え

    var ans = Int.MAX_VALUE
    for (bit in 0 until (1 shl N)) {
        var x = 0
        var y = 0
        for (i in 0 until N) {
            if (bit and (1 shl i) != 0) {
                x += xs[i]
            } else {
                y += xs[i]
            }
        }
        ans = Math.min(ans, Math.max(x, y))
    }
    println(ans)
}