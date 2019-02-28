package atcoder.ABC118

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var an = readLine()!!.split(" ").map { it.toLong() }


    while (true) {
        var minValue = Long.MAX_VALUE
        var minIndex = 0
        for ((i, v) in an.withIndex()) {
            if (v != 0L && v < minValue) {
                minValue = v
                minIndex = i
            }
        }
        var newlist = mutableListOf<Long>()
        var allzero = true
        for ((i, v) in an.withIndex()) {
            if (i == minIndex) {
                newlist.add(v)
            } else {
                val q = v % minValue
                if (q == 1L) {
                    println(1)
                    return
                }
                if (q != 0L) {
                    allzero = false
                }
                newlist.add(q)
            }
        }
        if (allzero) {
            println(minValue)
            return
        }
        an = newlist
    }

}