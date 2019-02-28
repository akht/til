package atcoder.AlSingProgrammingContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val h = readLine()!!.toInt()
    val w = readLine()!!.toInt()

    println((1 + n - h) * (1 + n - w))
}