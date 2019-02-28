package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    val n = readLine()!!.map { it.toInt() }
    var an = readLine()!!.split(" ").map { it.toLong() }

    var ans = 0
    while (an.all { it % 2 == 0L }) {
        an = an.map { it / 2 }.toMutableList()
        ans++
    }

    println(ans)
}