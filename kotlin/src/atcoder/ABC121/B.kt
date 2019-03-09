package atcoder.ABC121

fun main(args: Array<String>) {
    val (n, m, c) = readLine()!!.split(" ").map { it.toInt() }
    val b = readLine()!!.split(" ").map { it.toInt() }
    val am = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }

    var ans = 0
    for (list in am) {
        var v = 0
        for ((i, a) in list.withIndex()) {
            v += a * b[i]
        }
        v += c
        if (v > 0) {
            ans++
        }
    }
    println(ans)
}