package atcoder.ABC114

fun main(args: Array<String>) {
    val (x) = readLine()!!.split(" ").map { it.toInt() }

    if (x == 7 || x == 5 || x == 3) {
        println("YES")
    } else {
        println("NO")
    }
}