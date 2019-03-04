package atcoder.ABC120

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }
    println(Math.min(b / a, c))
}