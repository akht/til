package atcoder.ABC116

fun main(args: Array<String>) {
    val (ab, bc, ca) = readLine()!!.split(" ").map { it.toInt() }

    println(ab * bc / 2)
}