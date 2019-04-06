package atcoder.ABC123

fun main(args: Array<String>) {
    val n = readLine()!!.toLong()
    val cap = (1..5).map { readLine()!!.toLong() }

    if (cap.all { it >= n }) {
        println(5)
        return
    }

    val min = cap.min()!!
    val maxCost = Math.ceil(n.toDouble() / min).toLong()

    println(4 + maxCost)
}