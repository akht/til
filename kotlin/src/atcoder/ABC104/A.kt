package atcoder.ABC104

fun main(args: Array<String>) {
    val r = readLine()!!.toInt()

    val ans = when {
        r < 1200 -> "ABC"
        r < 2800 -> "ARC"
        else -> "AGC"
    }

    println(ans)
}