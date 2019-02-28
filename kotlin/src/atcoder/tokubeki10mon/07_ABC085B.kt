package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var ans = (1..n).map { readLine()!!.toInt() }.toSet().size

    println(ans)
}