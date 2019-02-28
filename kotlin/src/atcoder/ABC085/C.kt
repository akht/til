package atcoder.ABC085

fun main(args: Array<String>) {
    val (n, y) = readLine()!!.split(" ").map { it.toInt() }

    for (i in (0..n)) {
        for (j in (0..n-i)) {
            if (10000*i + 5000*j + 1000*(n-i-j) == y) {
                println("$i $j ${n-i-j}")
                return
            }
        }
    }
    println("-1 -1 -1")
}