package atcoder.ABC123

fun main(args: Array<String>) {
    val p = (1..5).map { readLine()!!.toInt() }
    val k = readLine()!!.toInt()

    if (p[4] - p[0] > k) {
        println(":(")
    } else {
        println("Yay!")
    }

}