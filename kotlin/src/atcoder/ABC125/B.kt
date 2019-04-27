package atcoder.ABC125

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val vs = readLine()!!.split(" ").map { it.toInt() }
    val cs = readLine()!!.split(" ").map { it.toInt() }

    var ans = 0
    for (i in 0 until n) {
        if (vs[i] - cs[i] > 0) {
            ans += vs[i] - cs[i]
        }
    }
    println(ans)
}