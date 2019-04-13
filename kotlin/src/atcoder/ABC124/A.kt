package atcoder.ABC124

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }

    if (a >= b) {
        if ((a - 1) >= b) {
            println(a + (a - 1))
        } else {
            println(a + b)
        }
    } else {
        if (a >= (b - 1)) {
            println(b + a)
        } else {
            println(b + (b - 1))
        }
    }
}