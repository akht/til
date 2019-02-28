package atcoder.ABC119

fun main(args: Array<String>) {
    val (a, b, q) = readLine()!!.split(" ").map { it.toInt() }
    val ss = (1..a).map { readLine()!!.toLong() }.sorted().toMutableList()
    val ts = (1..b).map { readLine()!!.toLong() }.sorted().toMutableList()
    val qs = (1..q).map { readLine()!!.toLong() }

    val inf = 1L shl 50

    ss.add(0, -inf)
    ss.add(inf)
    ts.add(0, -inf)
    ts.add(inf)

    for (q in qs) {
        var ans = Long.MAX_VALUE

        // 寺->神社のルート
        for (i in 0..1) {   // 0:東方向 1:西方向
            // 一番近い寺
            var temple = ts[if (i == 0) east(ts, q) else west(ts, q)]

            // 寺から東または西に行ったときに一番近い神社
            for (j in 0..1) {   // 0:東方向 1:西方向
                var shrine = ss[if (j == 0) east(ss, temple) else west(ss, temple)]

                val dist = Math.abs(q - temple) + Math.abs(temple - shrine)
                ans = Math.min(ans, dist)
            }
        }

        // 神社->寺のルート
        for (i in 0..1) {   // 0:東方向 1:西方向
            // 一番近い神社
            var shrine = ss[if (i == 0) east(ss, q) else west(ss, q)]

            // 神社から東または西に行ったときに一番近い寺
            for (j in 0..1) {   // 0:東方向 1:西方向
                var temple = ts[if (j == 0) east(ts, shrine) else west(ts, shrine)]

                val dist = Math.abs(q - shrine) + Math.abs(shrine - temple)
                ans = Math.min(ans, dist)
            }
        }

        println(ans)
    }
}

private fun <T: Comparable<T>> east(list: List<T>, q: T): Int {
    var i = list.binarySearch(q)
    if (i < 0) {
        i = -(i + 1)
    }

    return i
}

private fun <T: Comparable<T>> west(list: List<T>, q: T): Int {
    var i = list.binarySearch(q)
    if (i < 0) {
        i = -(i + 1)
        return i - 1
    }

    return i
}