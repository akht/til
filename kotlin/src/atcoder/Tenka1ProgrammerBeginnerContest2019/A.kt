package atcoder.Tenka1ProgrammerBeginnerContest2019

fun main(args: Array<String>) {
    val (a, b, c) = readLine()!!.split(" ").map { it.toInt() }

    if (c in Math.min(a, b)..Math.max(a, b)) {
        println("Yes")
    } else {
        println("No")
    }
}