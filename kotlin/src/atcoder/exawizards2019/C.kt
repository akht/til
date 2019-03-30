package atcoder.exawizards2019

fun main(args: Array<String>) {
    val (n, q) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!
    val tds = (1..q).map { readLine()!!.split(" ") }

    val map = mutableMapOf<String, MutableList<Int>>()
    for ((i, c) in s.withIndex()) {
        var indices = mutableListOf<Int>()
        val s = c.toString()
        if (map.containsKey(s)) {
            indices = map[s]!!
        }

        indices.add(i + 1)
        map[s] = indices
    }

    val array = Array(n + 2) { 1 }
    array[0] = 0
    array[n + 1] = 0

    for ((t, d) in tds) {
        if (map.containsKey(t)) {
            val indices = map[t]!!
            for (i in indices) {
                val m = array[i]
                if (d == "L") {
                    array[i] = 0
                    array[i - 1] += m
                } else {
                    array[i] = 0
                    array[i + 1] += m
                }
            }
        }
    }

    println(n - (array[0] + array[n + 1]))
}