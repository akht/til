package atcoder.ABC110

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map(String::toInt)

    var max = 0
    var min = 0
    var med = 0
    if (a > b) {
        if (a > c) {
            max = a
            if (b > c) {
                med = b
                min = c
            } else {
                med = c
                min = b
            }
        } else {
            max = c
            med = a
            min = b
        }
    } else {
        // b > a
        if (c > b) {
            max = c
            med = b
            min = a
        } else {
            max = b
            if (a > c) {
                med = a
                min = c
            } else {
                med = c
                min = a
            }
        }
    }

    val ans = max * 10 + med + min
    println(ans)
}