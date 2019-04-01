package atcoder.exawizards2019

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    val tds = (1..q).map { readLine()!!.split(" ") }


    // あるゴーレムが最終的にどのマスにいるかどうかはO(Q)で判定できるが
    // 全てのゴーレムを調べるにはO(QN)かかってしまいTLEになる
    // よくよく考えると、あるマスのゴーレムが左の端で消滅するなら
    // そのマスより左側にいたゴーレムもみんな消滅することがわかる
    // 右の橋についても同じことが言える
    // つまり、左の端で消滅するゴーレムのうち1番右側にいるものと、
    // 右の端で消滅するゴーレムのうち1番左側にいるものの位置が分かれば
    // 何体のゴーレムが消滅するのかがわかる
    // この右端と左端のゴーレムは二分探索で探すことができる
    // 二分探索O(logN)の各マスにおける消滅するかどうかの判定にはO(Q)かかるので
    // 全体ではO(QlogN)で問題が解ける

    // 消滅するかどうか判定する
    // 0:消滅しない -1:左端で消滅 1: 右端で消滅
    fun simulate(pos: Int): Int {
        var now = pos
        for ((t, d) in tds) {
            if (s[now].toString() != t) {
                continue
            }
            if (d == "L") {
                now--
            } else {
                now++
            }
            if (now < 0) {
                return -1
            } else if (now >= n) {
                return 1
            }
        }
        return 0
    }


    var low = -1
    var high = n
    while (Math.abs(high - low) > 1) {
        val mid = (high + low) / 2
        if (simulate(mid) == -1) {
            low = mid
        } else {
            high = mid
        }
    }
    var left = high

    low = -1
    high = n
    while (Math.abs(high - low) > 1) {
        val mid = (high + low) / 2
        if (simulate(mid) == 1) {
            high = mid
        } else {
            low = mid
        }
    }
    val right = low

    println(right - left + 1)
}
