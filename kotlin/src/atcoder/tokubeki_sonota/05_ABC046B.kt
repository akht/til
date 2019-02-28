package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }

    val ans = k * Math.pow((k-1).toDouble(), (n-1).toDouble()).toInt()
    println(ans)
}