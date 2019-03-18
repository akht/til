package ant_book

fun main(args: Array<String>) {

    // O(n^3)
//    solve_triple_loop()

    // O(nlogn)でいける
    solve_nlogn()

}

// O(n^3)
fun solve_triple_loop() {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map { it.toInt() }

    var ans = 0
    for (i in 0 until an.size) {
        for (j in i + 1 until an.size) {
            for (k in j + 1 until an.size) {

                // ３角形が作れる条件
                // 最長の辺の長さ < 残りの２辺の長さの和

                val len = an[i] + an[j] + an[k]
                val max = Math.max(an[i], Math.max(an[j], an[k]))
                val rest = len - max
                if (max < rest) {
                    ans = Math.max(ans, len)
                }
            }
        }
    }
    println(ans)
}

// O(nlogn)
fun solve_nlogn() {
    val n = readLine()!!.toInt()
    var an = readLine()!!.split(" ").map { it.toInt() }

    // 辺の配列を降順ソートし、前から最長の辺を決める
    // 最長の辺をa[i]とした場合、残りの2辺はa[i+1]とa[i+2]を選べばよい
    // (なぜならソート済なので、それ以降のどの2辺を選んでも和が大きくならないため)
    // 前から試していって、三角形が作れた時点でそれが答え
    // ソートにO(nlogn)かかり、調べるのにO(n)かかるので全体としてはO(nlogn)で行える

    an = an.sortedDescending()

    for (i in 0 until an.size - 2) {
        val len = an[i] + an[i + 1] + an[i + 2]
        val max = an[i]
        val rest = len - max
        if (max < rest) {
            println(len)
            return
        }
    }
    println(0)
}