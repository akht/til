package atcoder.ABC110

fun main(args: Array<String>) {
    val (n, m, x, y) = readLine()!!.split(" ").map(String::toInt)
    val xs = readLine()!!.split(" ").map(String::toInt)
    val ys = readLine()!!.split(" ").map(String::toInt)

    val maxXn = xs.max()!!
    val minYn = ys.min()!!

    val nowar = maxXn < minYn && (x + 1) <= minYn && maxXn <= (y - 2)

    val ans = if (nowar) {
        "No War"
    } else {
        "War"
    }
    println(ans)
}