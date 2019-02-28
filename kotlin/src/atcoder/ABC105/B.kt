package atcoder.ABC105

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val ans = (0..25).find { f -> (0..14).any { 4*f + 7*it == n } }.let { if (it == null) "No" else "Yes" }
    println(ans)
}
