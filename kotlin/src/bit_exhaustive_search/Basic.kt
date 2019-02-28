package bit_exhaustive_search

fun main(args: Array<String>) {

    // ビット全探索

    // ・n個の要素からなる集合 {0,1,…,n−10,1,…,n−1} の部分集合をすべて調べ上げる手法のこと
    // ・二進数とビットを用いて、ある集合の部分集合を全列挙（全探索）するアルゴリズムのこと
    // ・使う、使わないを整数の1つのbitにまとめることで、1つの整数のループで、複数のフラグのon/offを全探索する
    // ・0なら使わない、1なら使う、と解釈する

    // bit全探索は名前の通り，bit演算を使って全探索をする方法のこと．
    // n個の要素からなる集合の部分集合を全て列挙することができる．
    // 使えるケースとしては，n個の要素のそれぞれに対して，選ぶor選ばないみたいなフラグをつけて全ケースを調べたい場合など.

    // http://keita-matsushita.hatenablog.com/entry/2016/11/07/141236
    // http://lovedvoraklayout.hatenablog.com/entry/bit-full-search
    // https://qiita.com/drken/items/7c6ff2aa4d8fce1c9361#bit-%E5%85%A8%E6%8E%A2%E7%B4%A2
    // https://ameblo.jp/ayanahirun/entry-12398543348.html
    // https://blog.rossywhite.com/2018/08/06/bit-search/
    // http://tutuz.hateblo.jp/entry/2018/03/10/215802

    test0()

    println("------------------------------------------------------------")

    test1()

    println("------------------------------------------------------------")

    test2()

    println("------------------------------------------------------------")

    test3()
}

// 前提として、ビット演算のおさらい
fun test0() {

    // 1(10進数) -> 1(2進数)
    // 左シフト(shl関数)を適用すると、この1のビットが左にずれる

    val a = 1 shl 1     // 1 -> 10 (2進数)
    val b = 1 shl 2     // 10 -> 100 (2進数)
    val c = 1 shl 3     // 100 -> 1000 (2進数)
    val d = 1 shl 4     // 1000 -> 10000 (2進数)

    println("$a $b $c $d")

}

fun test1() {
    val n = 4

    // {0, 1, 2, 3}の部分集合を全列挙する
    for (bit in 0 until (1 shl n)) {

        // bitで表される集合

        // bitの表す集合を求める
        var list = mutableListOf<Int>()
        for (i in 0 until n) {
            if (bit and (1 shl i) != 0) {
                list.add(i)
            }
        }

        // bitの表す集合の出力
        print(bit)
        print(": {")
        for (i in 0 until list.size) {
            print(list[i])
            print(" ")
        }
        println("}")
    }
}


// bit全探索を使った部分集合を表すbit集合の列挙
fun test2() {
    val list = listOf("a", "b", "c")
    val len = list.size

    // {a, b, c}の部分集合を全列挙する
    for (bit in 0 until (1 shl len)) {
        // 1 << 3 => 8なので
        // (0 until 8)は２進数で表すと
        // (000 until 1000)となる
        // untilなので1000のひとつ前の111(10進数では7)までということなる
        // つまり、bitという変数は以下のように移っていく
        // 0 (000)
        // 1 (001)
        // 2 (010)
        // 3 (011)
        // 4 (100)
        // 5 (101)
        // 6 (110)
        // 7 (111)

        var s = "-"

        for (i in 0 until len) {
            // 対象が3要素なので(0 until 3)


            // ビットが立っているかどうかで判断する
            // 2通りの書き方がある

            // ビットが1かどうかで判断
            var on1 = 1 and (bit shr i) == 1
            // iが0から2まで動くので
            // bit >> i はそれぞれ以下のようになる
            // bit >> 0
            // bit >> 1
            // bit >> 2
            // 右シフト演算は、ビット列を右にずらす操作なので
            // たとえば bit = 100 なら
            // 100 >> 0 => 100
            // 100 >> 1 => 010
            // 100 >> 2 => 001 になる。
            // ( つまり1のビットの位置が左端から右端まで移動する )
            // ( つまり1桁ずつ移動させてビットANDすればビットが立っているものが判定できる )
            // これらにたいして (1 & x)とすると
            // 1(10進数) = 001(2進数)なので、
            // ビットAND(両方1なら1)の結果は
            // 1 & (4 >> 0) => 001 & 100 = 0
            // 1 & (4 >> 1) => 001 & 010 = 0
            // 1 & (4 >> 2) => 001 & 001 = 1 となる。
            // 結局これは、「1 & 」で一桁目をみていくという処理になる。
            // この例ではビットに1が立っているのはi = 2のときとなる。
            // こっちの書き方は、元となる集合のビットをひとつずつして
            // 固定された1(001)とビットANDする考え方

            // ビットが0でないかどうかで判断
            var on2 = bit and (1 shl i) != 0
            // 元となる集合のビットを固定して、1(001)のビットを左に動かしていき
            // ビットANDを取って、立っているビットを判定する考え方
            // こっちの書き方で注意しないといけないのは、
            // たとえば 010 & 010 => 010 = 2なので、「== 1」というように
            // 10進数の1と比べてはいけない。
            // 「!= 0」 というように判定する必要がある。

            if (on1) {
                s += list[i]
            }
        }

        println(s)
    }
}

fun test3() {
    val s = "123"
    val len = s.length

    var ans = 0L
    for (bit in 0 until (1 shl len-1)) {
        var num = (s[0] - '0').toLong()
        for (i in 0 until len-1) {
            if (bit and (1 shl i) != 0) {
                // +があれば、前後の数字が区切られて確定するので答えに足し合わせてリセットする
                ans += num
                num = 0
            }
            // 次の数字をセットする
            // もし+があった場合は↑で0に初期化されているので問題ない
            num = 10 * num + (s[i + 1] - '0')
        }
        ans += num
    }
    println(ans)
}