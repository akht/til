package atcoder.ABC122

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    val lr = (1..q).map { readLine()!!.split(" ").map { it.toInt() } }

    var cumsum = Array(n + 1) { 0 }

    for (i in 1 until n) {
        if (s[i - 1] == 'A' && s[i] == 'C') {
            cumsum[i + 1] = cumsum[i] + 1
        } else {
            cumsum[i + 1] = cumsum[i]
        }
    }

    for ((l, r) in lr) {
        val ans = cumsum[r] - cumsum[l]
        println(ans)
    }
}