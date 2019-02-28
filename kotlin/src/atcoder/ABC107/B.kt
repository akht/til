package atcoder.ABC107

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)

    val map = mutableListOf<String>()

    for (i in 1..h) {
        readLine()!!.let {
            if (it.any { c -> c == '#' }) {
                map.add(it)
            }
        }
    }

    val printRows = mutableListOf<Int>()
    for (i in 0 until w) {
        var dotOnly = true
        for (line in map) {
            if (line.substring(i, i+1) == "#") {
                dotOnly = false
            }
        }
        if (dotOnly) {
            printRows.add(i)
        }
    }

    for (line in map) {
        for ((index, c) in line.withIndex()) {
            if (!printRows.contains(index)) {
                print(c)
            }
        }
        println()
    }


    // このページを参考にして書き換える
    // https://beta.atcoder.jp/contests/abc107/submissions/3074745
}

fun p(map: List<String>) {
    for (line in map) {
        println(line)
    }
}