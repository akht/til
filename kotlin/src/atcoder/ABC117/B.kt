package atcoder.ABC117

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val lx = readLine()!!.split(" ").map { it.toInt() }

    if (lx.max()!! < (lx.sum() - lx.max()!!)) {
        println("Yes")
    } else {
        println("No")
    }
}