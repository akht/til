package atcoder.ABC106

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    var count = 0;
    for (i in 1..n step 2) {
        var divisor = 0
        for (j in 1..n step 2) {
            if (i % j == 0) {
                if (divisor == 8) {
                    divisor = -1
                    break
                }
                divisor++
            }
        }
        if (divisor == 8) {
            count++
        }
    }

    println(count)
}