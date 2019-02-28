package atcoder.ABC113

fun main(args: Array<String>) {
    val N = readLine()!!.toInt()
    val (T, A) = readLine()!!.split(" ").map { it.toInt() }
    val xs = readLine()!!.split(" ").map { it.toInt() }

    var ans = 0
    var diff = Double.MAX_VALUE
    for ((index, p) in xs.withIndex()) {
        var t = T - p * 0.006
        if (Math.abs(A - t) < diff) {
            diff = Math.abs(A - t)
            ans = index + 1
        }
    }
    println(ans)
}