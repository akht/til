package atcoder.ABC084

fun main(args: Array<String>) {
    val q = readLine()!!.toInt()
    val queries = (1..q).map { readLine()!!.split(" ").map { it.toInt() } }

    val n = 10e5.toInt()
    val s = Array(n) {0}
    for (i in 1 until n) {
        val flg = if ((i and 1 == 1) && isPrime(i) && isPrime((i + 1) / 2)) 1 else 0
        s[i] = s[i - 1] + flg
    }

    for ((l, r) in queries) {
        println(s[r] - s[l - 1])
    }
}

fun isPrime(x: Int): Boolean {
    if (x <= 1) {
        return false
    }

    for (i in 2..Math.sqrt(x.toDouble()).toInt()) {
        if (x % i == 0) {
            return false
        }
    }

    return true
}