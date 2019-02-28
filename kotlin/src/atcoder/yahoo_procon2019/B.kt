package atcoder.yahoo_procon2019

fun main(args: Array<String>) {
    val xs = (1..3).map { readLine()!!.split(" ").map { it.toInt() } }
    val count = Array(5) { 0 }
    xs.forEach {
        count[it[0]]++
        count[it[1]]++
    }

    if (count[1] <= 2 && count[2] <= 2 && count[3] <= 2 && count[4] <= 2) {
        println("YES")
    } else {
        println("NO")
    }
}