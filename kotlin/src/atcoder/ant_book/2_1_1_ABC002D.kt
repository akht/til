package atcoder.ant_book

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val xy = (1..m).map { readLine()!!.split(" ").map { it.toInt() } }.map { Pair(it[0], it[1]) }.toSet()

//    神からの財産と、母音を取り戻した高橋くんは、AtCoder国の腐敗した政治を正すため、国会議員となろうと決めました。
//    もともと人心掌握術とスピーチに定評があった高橋くんは、何の苦労をすることもなく当選しました。
//    しかし、議員になってからが本番です。国を正すためには、首相に任命される必要があります。
//
//    AtCoder国には高橋くんを除いて N 人の国会議員と、M 個の人間関係 (x, y) が存在します。
//    人間関係 (x, y) とは、議員 x と議員 y が知り合いであることを意味します。
//    高橋くんは N 人の議員から何人かを選んで派閥を作ろうと企んでいます。
//    派閥に含まれるすべての議員は互いに知り合いでなければなりません。
//    高橋くんが作成することができる最大の派閥に属する議員数を求めるプログラムを書いてください。

    // N人いる議員を横に並べて、それぞれをビットに見立てて
    // ビットが立っている議員同士が知り合いだと仮定し、
    // ビットが立っている人たちが実際に知り合いかどうかを調べる
    // ビットが立っている人たち全員が互いに知り合いだったら、ビットが立っている数が派閥ということになる
    // 2^Nで求められる

    var ans = 0

    for (bit in 0 until (1 shl n)) {
        // 互いに知り合いと仮定する人たちのリスト
        val list = mutableListOf<Int>()
        for (i in 0 until n) {
            if (1 and (bit shr i) == 1) {
                // ビットが立っていたら知り合いリストに入れる
                list.add(i+1)
            }
        }

        // 知り合いリストをなめて、実際に全てのペアが知り合いかどうかを調べる
        // 全てのペアが知り合い同士なら、リストの人数が派閥の数ということになる
        var notContain = false
        for (i in 0 until list.size) {
            for (j in i + 1 until list.size) {
                val pair = Pair(list[i], list[j])
                if (!xy.contains(pair)) {
                    notContain = true
                    break
                }
            }
            if (notContain) {
                break
            }
        }
        if (notContain) {
            continue
        }
        ans = Math.max(ans, list.size)
    }
    println(ans)
}