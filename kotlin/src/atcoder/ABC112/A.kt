package atcoder.ABC112

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val ans = when (n) {
        1 -> "Hello World"
        else -> readLine()!!.toInt() + readLine()!!.toInt()
    }

    println(ans)
}