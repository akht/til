package atcoder.KEYENCEProgrammingContest2019

fun main(args: Array<String>) {
    val ns = readLine()!!.split(" ").map { it.toInt() }.toList()

    if (listOf(1, 9, 7, 4).all { ns.contains(it) }) {
        println("YES")
    } else {
        println("NO")
    }
}