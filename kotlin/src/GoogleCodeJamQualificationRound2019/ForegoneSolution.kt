package GoogleCodeJamQualificationRound2019

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val nn = (1..t).map { readLine()!!.toLong() }

    for ((i, n) in nn.withIndex()) {
        var a = ""
        var b = ""
        for (c in n.toString()) {
            if (c == '0') {
                if (a != "") {
                    a += '0'
                }
                if (b != "") {
                    b += '0'
                }
            } else if (c == '1') {
                a += '1'
                if (b != "") {
                    b += '0'
                }
            } else if (c == '5') {
                a += '2'
                b += '3'
            } else {
                a += '1'
                b += (c - '0') - 1
            }
        }
        println("Case #${i + 1}: $a $b")
    }
}
