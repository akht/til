package atcoder.AGC030

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toLong() }

    if (a + b + b + 1 < b + c) {
        println(a + b + b + 1)
    } else {
        println(b + c)
    }
}