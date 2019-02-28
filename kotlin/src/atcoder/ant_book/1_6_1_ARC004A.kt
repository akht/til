package atcoder.ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val ps = (0 until n).map { readLine()!!.split(" ").map { it.toInt() } }

    var ans = 0.0
    for (i in 0 until n) {
        for (j in i+1 until n) {
            ans = Math.max(dist(ps[i], ps[j]), ans)
        }
    }
    println(ans)
}

fun dist(p1: List<Int>, p2: List<Int>): Double {
    return Math.sqrt(Math.pow((p1[0] - p2[0]).toDouble(), 2.0) + Math.pow((p1[1] - p2[1]).toDouble(), 2.0))
}