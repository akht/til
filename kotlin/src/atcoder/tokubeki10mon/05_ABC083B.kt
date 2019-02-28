package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    val (n, a, b) = readLine()!!.split(" ").map { it.toInt() }

    val ans = (1..n).filter { it.toString().toCharArray().map { it - '0' }.sum() in a..b }.sum()
    println(ans)
}