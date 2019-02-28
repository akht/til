package atcoder.ABC115

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val px = (1..n).map { readLine()!!.toInt() }.sorted().reversed()

    println(px.sum() - (px.first() / 2))
}