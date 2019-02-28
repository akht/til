package atcoder.ABC050

fun main(args: Array<String>) {
    val (a, op, b) = readLine()!!.split(" ")

    if (op == "+") {
        println(a.toInt() + b.toInt())
    } else {
        println(a.toInt() - b.toInt())
    }
}