package atcoder.soundhound2018_summer_qual

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toInt)

    val ans = when {
        a + b == 15 -> "+"
        a * b == 15 -> "*"
        else -> "x"
    }

    println(ans)
}