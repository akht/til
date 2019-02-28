package atcoder.ant_book

fun main(args: Array<String>) {
    val (n, y) = readLine()!!.split(" ").map { it.toInt() }

    for (i in 0..n) {
        for (j in 0..n-i) {
            if (i*10000 + j*5000 + (n - i - j)*1000 == y) {
                println("$i $j ${n-i-j}")
                return
            }
        }
    }
    println("-1 -1 -1")
}