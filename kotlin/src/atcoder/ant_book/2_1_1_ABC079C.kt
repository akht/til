package atcoder.ant_book

fun main(args: Array<String>) {
    val abcd = readLine()!!

    for (bit in 0..7) {
        var exp = abcd[0].toString()
        var eval = abcd[0] - '0'
        for (i in 0..2) {
            if (1 and (bit shr i) == 1) {
                exp += "+" + abcd[i+1]
                eval += abcd[i+1] - '0'
            } else {
                exp += "-" + abcd[i+1]
                eval -= abcd[i+1] - '0'
            }
        }
        if (eval == 7) {
            println("$exp=7")
            return
        }
    }
}