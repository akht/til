package atcoder.ABC112

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xs = (1..n).map { readLine()!!.split(" ").map(String::toInt) }

    (0..100).forEach { x ->
        (0..100).forEach { y ->
            val p = xs.first { xyh -> xyh[2] != 0}
            val h = Math.abs(x - p[0]) + Math.abs(y - p[1]) + p[2]
            var c = xs.all { it[2] == Math.max(h - Math.abs(x - it[0]) - Math.abs(y - it[1]), 0) }
            if (c) {
                println("$x $y $h")
                return
            }
        }
    }
}