package atcoder.ABC100

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toInt)

    var ans = if (a <= 8 && b <= 8) "Yay!" else ":("
    println(ans)
}