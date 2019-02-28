package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()
    val x = readLine()!!.toInt()

    var ans = 0
    for (i in 0..a) {
        for (j in 0..b) {
            for (k in 0..c) {
                if (500 * i + 100 * j + 50 * k == x) {
                    ans++
                }
            }
        }
    }

    println(ans)
}