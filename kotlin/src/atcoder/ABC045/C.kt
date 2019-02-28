package atcoder.ABC045

fun main(args: Array<String>) {
    val s = readLine()!!
    var len = s.length

    var ans = 0L

    // 125の場合、+が入るのは2箇所なので00,01,10,11の4パターンのビットで考える
    for (bit in 0 until (1 shl len-1)) {

        // 最初は先頭の数字を入れておく
        var num = (s[0] - '0').toLong()

        // ビットが立っている位置を探す
        // ビットが立っている位置に+を入れると考える
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
