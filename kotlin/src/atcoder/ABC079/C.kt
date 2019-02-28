package atcoder.ABC079

fun main(args: Array<String>) {
    val abcd = readLine()!!
    val len = abcd.length

    for (bit in 0 until (1 shl len - 1)) {

        var exp = abcd[0].toString()
        var eval = abcd[0] - '0'

        for (i in 0 until len - 1) {
            if (1 and (bit shr i) == 1) {
                // ビットが立っていたら+
                exp += "+" + abcd[i+1]
                eval += abcd[i+1] - '0'
            } else {
                // ビットが立ってなければ-
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