package atcoder.Tenka1ProgrammerBeginnerContest

fun main(args: Array<String>) {
    var (a, b, k) = readLine()!!.split(" ").map { it.toInt() }

    for (i in (1..k)) {
        if (i % 2 == 1) {
            b += a / 2
            a /= 2
        } else {
            a += b / 2
            b /= 2
        }
    }
    println("$a $b")
}