package atcoder.ABC113

fun main(args: Array<String>) {
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }
    println(x + (y / 2))
}