package atcoder.ABC114

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()

    var factMap = mutableMapOf<Int, Map<Int, Int>>()
    (2..n).forEach { factMap[it] = fac(it) }

    println(factMap)
}

// 素因数分解する
fun fac(n: Int): Map<Int, Int> {
    var factMap = mutableMapOf<Int, Int>()

    var x = n
    for (i in 2..97) {
        var pi = 0
        while (x % i == 0) {
            pi++
            x /= i
        }
        if (0 < pi) {
            factMap[i] = pi
        }
    }

    return factMap
}