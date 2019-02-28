package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val mod = 1000000007
    var ans = 1L
    for (i in 1..n) {
        ans = ans * i % mod
    }
    println(ans)
}