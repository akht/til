package atcoder.ABC115

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val hx = (1..n).map { readLine()!!.toLong() }.sorted()

    // 小さい順にソートして、前からk本の部分集合をとり
    // hmax - hminを計算してみる

    var ans = Long.MAX_VALUE
    for ((i, hi) in hx.withIndex()) {
        if (hx.size < i + k) {
            break
        }

        val hmax = hx[i + k - 1]
        val hmin = hx[i]
        ans = Math.min(ans, hmax - hmin)
    }

    println(ans)
}