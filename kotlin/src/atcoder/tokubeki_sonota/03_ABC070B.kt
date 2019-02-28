package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val (a, b, c, d) = readLine()!!.split(" ").map { it.toInt() }

    println(Math.max(0, Math.min(b, d) - Math.max(a, c)))
}