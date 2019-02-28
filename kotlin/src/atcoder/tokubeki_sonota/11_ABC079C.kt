package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val abcd = readLine()!!

    for (bit in 0 until (1 shl abcd.length - 1)) {
        var expr = abcd[0].toString()
        var eval = abcd[0] - '0'
        for (i in 0 until abcd.length - 1) {
            if (1 and (bit shr i) == 1) {
                expr += "+" + abcd[i + 1]
                eval += abcd[i + 1] - '0'
            } else {
                expr += "-" + abcd[i + 1]
                eval -= abcd[i + 1] - '0'
            }
        }
        if (eval == 7) {
            println("$expr=7")
            return
        }
    }
}