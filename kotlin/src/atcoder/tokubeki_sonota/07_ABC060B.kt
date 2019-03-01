package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

    if ((1..b).any { a * it % b == c }) {
        println("YES")
    } else {
        println("NO")
    }
}