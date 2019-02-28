package atcoder.ABC119

import java.math.BigDecimal

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xu = (1..n).map { readLine()!!.split(" ") }

    val u = BigDecimal.valueOf(380000.0)

    var ans: BigDecimal = BigDecimal.ZERO
    for (l in xu) {
        if (l[1] == "JPY") {
            ans  = ans.add(BigDecimal.valueOf(l[0].toDouble()))
        } else {
            ans = ans.add(BigDecimal.valueOf(l[0].toDouble()).multiply(u))
        }
    }
    println(ans.toPlainString())
}