package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val r = readLine()!!.toInt()
    val x = readLine()!!.split(" ").map { it.toInt() }.sorted()

    // 1番左の点から貪欲に処理していく(点をあらかじめソートしておく)

    var ans = 0
    var i = 0
    while (i < n) {
        // カバーされていない左端の点
        val uncoverPoint = x[i]
        i++

        // カバーされていないところから距離rを超えるまで進める
        while (i < n && x[i] - uncoverPoint <= r) {
            i++
        }

        // 印をつける点
        val signedPoint = x[i - 1]
        // 印をつけたところから距離rを超えるまで進める
        while (i < n && x[i] - signedPoint <= r) {
            i++
        }

        ans++
    }
    println(ans)
}