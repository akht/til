package ant_book

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val ks = readLine()!!.split(" ").map { it.toInt() }

    val size = ks.size

    // O(n^4)

    for (i in 0 until size) {
        for (j in 0 until size) {
            for (k in 0 until size) {
                for (l in 0 until size) {
                    val sum = ks[i] + ks[j] + ks[k] + ks[l]
                    if (sum == m) {
                        println("Yes")
                        return
                    }
                }
            }
        }
    }
    println("No")
}