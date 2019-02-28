package atcoder.ABC118

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val list = (1..n).map { readLine()!!.split(" ").map { it.toInt() } }

    val foods = Array(m+1) {0}
    for (l in list) {
        for (i in 1 until l.size) {
            foods[l[i]]++
        }
    }

    val ans = foods.filter { it == n }.count()
    println(ans)
}