package atcoder.ABC101

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toInt)

    println(1 + ( ((n-k) + (k-1) - 1) / (k-1) ))
}