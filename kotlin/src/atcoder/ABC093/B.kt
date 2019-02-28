package atcoder.ABC093

fun main(args: Array<String>) {
    val (A, B, K) = readLine()!!.split(" ").map { it.toInt() }

    ((A until Math.min(A + K, B)) + (Math.max(A, B - K + 1)..B)).toSet().map { println(it) }
}