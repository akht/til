package atcoder.ABC123

fun main(args: Array<String>) {
    val menu = (1..5).map { readLine()!!.toInt() }

    var max = 0
    for (m in menu) {
        if (m % 10 == 0) {
            continue
        }
        max = Math.max(max, 10 - (m % 10))
    }

    var ans = 0
    for (m in menu) {
        if (m % 10 == 0) {
            ans += m
            continue
        }
        ans += m + (10 - (m % 10))
    }
    ans -= max

    println(ans)
}