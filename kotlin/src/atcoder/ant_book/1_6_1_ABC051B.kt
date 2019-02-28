package atcoder.ant_book

fun main(args: Array<String>) {
    val (k, s) = readLine()!!.split(" ").map { it.toInt() }

    var ans = 0
    for (x in 0..k) {
        for (y in 0..k) {
            if (s - x - y in 0..k) {
                ans++
            }
        }
    }
    println(ans)
}