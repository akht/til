package atcoder.ABC125

fun main(args: Array<String>) {
    val (a, b, t) = readLine()!!.split(" ").map { it.toInt() }

    println(b * (t / a))
}