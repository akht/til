package atcoder.ABC108

fun main(args: Array<String>) {
    val (x1, y1, x2, y2) = readLine()!!.split(" ").map(String::toInt)

    val dx = x2 - x1
    val dy = y2 - y1

    val x3 = x2 - dy
    val y3 = y2 + dx

    val x4 = x3 - dx
    val y4 = y3 - dy

    println("$x3 $y3 $x4 $y4")
}