package atcoder.ABC120

fun main(args: Array<String>) {
    var (a, b, k) = readLine()!!.split(" ").map { it.toInt() }
    var i = 0
    var d = Math.min(a, b) + 1
    while (k != 0) {
        d--
        if (a % d == 0 && b % d == 0) {
            k--
        }
    }
    println(d)
}