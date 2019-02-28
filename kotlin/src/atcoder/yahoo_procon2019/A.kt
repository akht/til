package atcoder.yahoo_procon2019

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    if (2 * k - 1 <= n) {
        println("YES")
    } else {
        println("NO")
    }
}