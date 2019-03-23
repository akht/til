package ant_book

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var l = readLine()!!.split(" ").map { it.toLong() }.toMutableList()

    // 21 -> 13, 8 = 21
    // 13 -> 5,  8 = 13
    // 合計: 34

    // 21 -> 5, 16 = 21
    // 16 -> 8,  8 = 16
    // 合計: 37

    // 切った残りの板をまた切るとき、より短い板になっている方がコストが小さくなる
    // つまり目的の長さの大きいものから切り出していけば良い

//    l = l.sortedDescending()
//
//    var len = l.sum()
//
//    var ans = 0L
//    for (i in 0 until n - 1) {
//        ans += len
//        len -= l[i]
//    }
//    println(ans)

    // と思ったがこれは罠で、
    // ↓みたいな時がダメ

    // 長いのから切り出していくと合計コスト=33
    // 12 -> 9, 3 = 12
    //  9 -> 6, 3 = 9
    //  6 -> 4, 2 = 6
    //  4 -> 2, 2 = 4
    //  2 -> 1, 1 = 2

    // 最適解の合計コスト=30
    // 12 -> 7, 5 = 12
    //  7 -> 4, 3 = 7
    //  5 -> 2, 3 = 5
    //  4 -> 2, 2 = 4
    //  2 -> 1, 1 = 2


    // 板の切り出し方が二分木に対応する
    // 最適な切り出し方を考えた時、最後に切るのは1番短い板とその次に短い板になるはず
    // そのひとつ前のステップも同様に、1番短い板とその次に短い板を切り出したはず
    // というように、ボトムアップで考える


    l = l.sorted().toMutableList()

    var ans = 0L

    // 板が1本になるまで
    while (n > 1) {
        // 1番短い板mii1, 次に短い板mii2を求める
        var mii1 = 0
        var mii2 = 1
        if (l[mii1] > l[mii2]) {
            mii1 = 1
            mii2 = 2
        }

        for (i in 2 until n) {
            if (l[i] < l[mii1]) {
                mii2 = mii1
                mii1 = i
            } else if (l[i] < l[mii2]) {
                mii2 = i
            }
        }

        // それらを併合
        val t = l[mii1] + l[mii2]
        ans += t

        if (mii1 == n - 1) {
            val tmp = mii1
            mii1 = mii2
            mii2 = tmp
        }
        l[mii1] = t;
        l[mii2] = l[n - 1]
        n--
    }
    println(ans)
}