package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    var  ans = 0
    for ((i, a) in an.withIndex()) {
        if (i % 2 == 0) {
            ans += a
        } else {
            ans -= a
        }
    }

    println(ans)
}