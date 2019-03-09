package atcoder.ABC121

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }

    val keta_b = binaryKetasu(b)

    var ans = 0L
    for (i in 0 until keta_b) {
        val now = Math.pow(2.0, i.toDouble()).toLong()
        val aa = a / now
        val bb = b / now
        val q1 = a % now
        val q2 = b % now
        if (aa % 2 == 0L && bb % 2 == 0L) {
            if (i == 0) {
                var x = (b - a + 1) / 2
                if (a % 2 != 0L) {
                    x += 1
                }
                if (x % 2 == 1L) {
                    ans += 1
                }
            }
        } else if (aa % 2 == 0L && bb % 2 != 0L) {
            if (q2 % 2 == 0L) {
                ans += now
            }
        } else if (aa % 2 != 0L && bb % 2 == 0L) {
            if (q1 % 2 != 0L) {
                ans += now
            }
        } else {
            if (Math.abs(q1 - q2) % 2 == 0L) {
                ans += now
            }
        }
    }
    println(ans)
}

fun binaryKetasu(n: Long): Int {
    return (Math.log10(n.toDouble()) / Math.log10(2.0) + 1).toInt()
}
