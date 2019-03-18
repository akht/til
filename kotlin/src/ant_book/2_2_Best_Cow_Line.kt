package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var s = readLine()!!

    // 単純に先頭と末尾を比べて小さい方から選んでいけばいいかと思ったがそれは罠で
    // 先頭と末尾が同じ文字だったときには、その次の文字が小さい方を選ばないといけない
    // その次の文字が同じだったらさらにその次までみないといけない
    // 例えばS=ACDBCBのとき、先頭と末尾を比べていくと
    // S=CDBC T=ABの段階に出くわす
    // ここで末尾のCを選ばないと、その次でBを選べない
    // これを解決するために、辞書順の性質を使う
    // 毎回Sとそれを反転させたS'を辞書順で比べれば、
    // 同じ文字があった時も正しく選択できる
    // 【例】
    //     S = CDBC
    //     S'= CBDC
    // この場合はS'の方が辞書順で小さいのでS'の先頭を選ぶ(=元の文字列Sの末尾を選ぶ)

    var ans = ""

    var head = 0
    var tail = n - 1
    while (head <= tail) {
        var isHeadSmallerThamTail = false
        for (i in 0..tail - head) {
            if (s[head] < s[tail]) {
                isHeadSmallerThamTail = true
                break
            } else {
                isHeadSmallerThamTail = false
                break
            }
        }

        if (isHeadSmallerThamTail) {
            ans += s[head]
            head++
        } else {
            ans += s[tail]
            tail--
        }
    }
    println(ans)
}