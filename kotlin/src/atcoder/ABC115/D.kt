package atcoder.ABC115

fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(" ").map { it.toLong() }

    // 各レベルのバーガーの層の数
    val lx = mutableListOf<Long>()
    var l = 1L
    lx.add(l)

    // 各レベルのバーガーのPの数
    var px = mutableListOf<Long>()
    var p = 1L
    px.add(p)

    for (i in (0..50)) {
        l = 2 * lx[i] + 3
        lx.add(l)

        p = 2 * px[i] + 1
        px.add(p)
    }

    println(count(n.toInt(), x, lx, px))
}

fun count(n: Int, x: Long, lx: List<Long>, px: List<Long>): Long {
    if (x == 0L) {
        return 0
    }
    if (n == 0) {
        return 1
    }

    var ret = 0L

    // レベルNのバーガーの総数
    var size = lx[n]
    var half = size / 2 + 1
    if (x < half) {
        // 半分より少ない時
        ret = count(n - 1, x - 1, lx, px)
    } else if (x == half) {
        // ちょうど半分の時
        ret = px[n - 1] + 1
    } else {
        // 半分より多い時
        ret = px[n - 1] + 1 + count(n - 1, x - half, lx, px)
    }

    return ret
}