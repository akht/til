package atcoder.Tenka1ProgrammerBeginnerContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val k = readLine()!!.toInt()

    var c = s[k - 1]

    val ans = s.map { if (it == c) it else '*' }.joinToString("")
    println(ans)
}