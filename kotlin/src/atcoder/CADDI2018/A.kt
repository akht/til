package atcoder.CADDI2018

fun main(args: Array<String>) {
    var n = readLine()!!

    val ans = n.filter { it == '2' }.length
    println(ans)
}