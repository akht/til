package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val ss = readLine()!!.split(" ").map { it.toLong() }
    val tt = readLine()!!.split(" ").map { it.toLong() }

    // 選べる仕事の中から終了時間が早いものから選んでいく
    // 終了時間が早いほど、残りの時間が長くなるのでより多く選べそう

    val work = ss.zip(tt).sortedBy { it.second }

    var ans = 1
    var end = work[0].second
    for (i in 1 until n) {
        val nextWork = work[i]
        if (end < nextWork.first) {
            ans++
            end = nextWork.second
        }
    }
    println(ans)
}