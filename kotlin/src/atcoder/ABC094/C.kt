package atcoder.ABC094

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xs = readLine()!!.split(" ").map { it.toLong() }

    val sorted = xs.sorted()

    val left = (n / 2) - 1
    val right = left + 1

    for (x in xs) {
        if (x <= sorted[left]) {
            println(sorted[right])
        } else {
            println(sorted[left])
        }
    }
}
