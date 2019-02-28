package atcoder.ABC118

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }

    if (b % a == 0) {
        println(a + b)
    } else {
        println(b - a)
    }
}