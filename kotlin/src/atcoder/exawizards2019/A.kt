package atcoder.exawizards2019

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

    if (a == b && b == c) {
        println("Yes")
    } else {
        println("No")
    }

}