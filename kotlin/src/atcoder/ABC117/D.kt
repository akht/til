package atcoder.ABC117

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val list = readLine()!!.split(" ").map { it.toLong() }

    var x = list[0]
    for (i in 1 until list.size) {
        x = x xor list[i]
    }

    if (k < x * 2) {
        val xorsum = list.map { x xor it }.sum()
        println(xorsum)
    } else {

    }


}