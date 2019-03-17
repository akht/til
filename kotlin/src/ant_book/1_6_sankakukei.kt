package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map { it.toInt() }

    var ans = 0
    for (i in 0 until an.size) {
        for (j in i + 1 until an.size) {
            for (k in j + 1 until an.size) {

                // ３角形が作れる条件
                // 最長の辺の長さ < 残りの２辺の長さの和

                val len = an[i] + an[j] + an[k]
                val max = Math.max(an[i], Math.max(an[j], an[k]))
                val rest = len - max
                if (max < rest) {
                    ans = Math.max(ans, len)
                }
            }
        }
    }
    println(ans)
}