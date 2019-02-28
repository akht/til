package atcoder.ABC112

fun main(args: Array<String>) {
    val (n, t) = readLine()!!.split(" ").map(String::toInt)
    val ct = (1..n).map { readLine()!!.split(" ").map(String::toInt) }
            .filter { it[1] <= t }
            .sortedBy { it[0] }

    val ans = if (ct.isEmpty()) { "TLE" } else { ct[0][0] }
    println(ans)
}