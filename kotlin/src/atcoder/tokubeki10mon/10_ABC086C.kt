package atcoder.tokubeki10mon

data class Point(val t: Int, val x: Int, val y: Int)

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val points = (1..n).map {
        val triple = readLine()!!.split(" ").map { it.toInt() }
        Point(triple[0], triple[1], triple[2])
    }.toMutableList()

    points.add(0, Point(0, 0, 0))

    fun dist(p1: Point, p2: Point): Int = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y)

    for (i in (0 until points.size - 1)) {
        val now = points[i]
        val next = points[i + 1]

        val dist = dist(now, next)
        val dt = next.t - now.t

        if (dt < dist) {
            println("No")
            return
        }
        if ((dt % 2 == 0) != (dist % 2 == 0)) {
            println("No")
            return
        }
    }

    println("Yes")
}