package atcoder.AlSingProgrammingContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }

    val groupby = readLine()!!.split(" ").map { it.toInt() }
            .groupBy {
                when {
                    b < it -> 1
                    a < it -> 0
                    else -> -1
                }
            }

    if (groupby.size != 3) {
        println(0)
    } else {
        println(groupby.map { it.value.size }.min()!!)
    }
}