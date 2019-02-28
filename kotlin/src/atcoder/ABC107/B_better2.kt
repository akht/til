package atcoder.ABC107

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)
    val first = mutableListOf<String>()
    for (i in 0 until h) {
        readLine()!!.let { if (it.any { c -> c == '#' }) first.add(it) }
    }

    val indexes = mutableListOf<Int>()
    for (j in 0 until w) {
        if (first.map { it[j - 1] }.all { c -> c == '.' }) indexes.add(j - 1)
    }

    first.map { it.filterIndexed { index, _ -> !indexes.contains(index) }.forEach(::println) }
}