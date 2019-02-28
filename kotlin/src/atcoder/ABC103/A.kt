package atcoder.ABC103

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map(String::toInt)

    val max = Math.max(Math.max(a, b), c)
    val min = Math.min(Math.min(a, b), c)

    println(max - min)
}