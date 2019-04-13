package atcoder.ABC124

fun main(args: Array<String>) {
    val s = readLine()!!

    val len = s.length
    var diff1 = 0
    var diff2 = 0
    for (i in 0 until len) {
        var c1 = '0'
        var c2 = '0'
        if (i % 2 == 0) {
            c1 = '0'
            c2 = '1'
        } else {
            c1 = '1'
            c2 = '0'
        }

        if (s[i] != c1) {
            diff1++
        }
        if (s[i] != c2) {
            diff2++
        }
    }
    println(Math.min(diff1, diff2))
}