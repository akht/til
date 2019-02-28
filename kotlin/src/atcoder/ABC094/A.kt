package atcoder.ABC094

fun main(args: Array<String>) {
    val (a, b, x) = readLine()!!.split(" ").map(String::toInt)

    val ans = if ((a <= x) and (x <= a + b)) "YES" else "NO"
    println(ans)

}