package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val (a, b, x) = readLine()!!.split(" ").map { it.toLong() }

    if (a % x == 0L) {
        println(b / x - a / x + 1)
    } else {
        println(b / x - a / x)
    }
}