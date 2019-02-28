package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    val (n, y) = readLine()!!.split(" ").map { it.toInt() }

    for (a in 0..n) {
        for (b in 0..n-a) {
            val remain = y - 10000 * a + 5000 * b
            val c = n - a - b
            if (0 <= remain && 1000 * c == remain) {
                println("$a $b $c")
                return
            }
        }
    }

    println("-1 -1 -1")
}