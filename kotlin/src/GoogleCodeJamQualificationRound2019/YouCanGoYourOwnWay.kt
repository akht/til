package GoogleCodeJamQualificationRound2019

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val cases = (1..t).map {
        val n = readLine()!!.toInt()
        val path = readLine()!!
        Pair(n, path)
    }

    for ((i, case) in cases.withIndex()) {
        val mine = case.second.map { if (it == 'E') 'S' else 'E' }.joinToString(separator = "")

        println("Case #${i+1}: $mine")
    }
}