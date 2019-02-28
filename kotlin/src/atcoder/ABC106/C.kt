package atcoder.ABC106

fun main(args: Array<String>) {
    val s = readLine()!!
    val k = readLine()!!.toLong()

    if (s.first() != '1') {
        println(s.first())
        return
    }

    val len = s.takeWhile { it == '1' }.length
    if (k <= len) {
        println("1")
        return
    }

    val ans = s.dropWhile { it == '1' }.first()
    println(ans)
}