package atcoder.ABC094

fun main(args: Array<String>) {
    val (n, m, x) = readLine()!!.split(" ").map(String::toInt)
    val list = readLine()!!.split(" ").map(String::toInt)

    val (left, right) = list.partition { it < x }
    println(Math.min(left.size, right.size))
}