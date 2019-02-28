package atcoder.ABC105

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map(String::toInt)

    if (n % k == 0) {
        println("0")
    } else {
        println("1")
    }
}
