package atcoder.ABC105

fun main(args: Array<String>) {
    var N = readLine()!!.toInt()

    if (N == 0) {
        println("0")
        return
    }

    var ans = ""
    while (N != 0) {
        var q = if (N % 2 == 0) N / -2 else (N - 1) / -2
        var r = if (N % 2 == 0) 0 else 1
        N = q
        ans += r
    }
    println(ans.reversed())
}