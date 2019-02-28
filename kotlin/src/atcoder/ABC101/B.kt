package atcoder.ABC101

fun main(args: Array<String>) {
    val n = readLine()!!
    val sn = n.sumBy { it - '0' }

    println(if (n.toInt() % sn == 0) "Yes" else "No")
}