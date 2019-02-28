package atcoder.ABC103

fun main(args: Array<String>) {
    var s = readLine()!!
    val t = readLine()!!

    if (s == t) {
        println("Yes")
        return
    }

    fun String.rotate() = drop(length - 1) + take(length - 1)

    for (i in 1..s.length) {
        s = s.rotate()
        if (s == t) {
            println("Yes")
            return
        }
    }

    println("No")
}