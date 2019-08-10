package ant_book

fun main(args: Array<String>) {

    // O(n^4)
//    solve1()

    // O(n^3logn)
//    solve2()

    // O(n^2logn)
    solve3()

}

// O(n^4)
private fun solve1() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    val ks = readLine()!!.split(" ").map { it.toInt() }

    val size = ks.size
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

// O(n^3logn)
private fun solve2() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    var ks = readLine()!!.split(" ").map { it.toInt() }

    // 一番内側のループを、for分で線形探索するのではなく二分探索する

    ks = ks.sorted()

    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                val d = m - (ks[i] + ks[j] + ks[k])
                if (binarySearch(ks, d)) {
                    println("Yes")
                    return
                }
            }
        }
    }
    println("No")
}

private fun binarySearch(list: List<Int>, target: Int): Boolean {
    var ng = -1
    var ok = list.size
    while (Math.abs(ng - ok) > 1) {
        val mid = (ng + ok) / 2
        if (list[mid] == target) {
            return true
        } else {
            ng = mid
        }
    }
    return false
}

// O(n^2logn)
private fun solve3() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    var ks = readLine()!!.split(" ").map { it.toInt() }

    // 内側の２つのループに着目する
    // ks[k] + ks[l] = m - (ks[i] + ks[j])となるようなペアがks配列のなかにあればよい

    // ks[k] + ks[l]が取りうる値を求めてソートしておく
    val sum = (0 until n).map { it -> (0 until n).map { it2 -> ks[it] + ks[it2] } }.flatten().distinct().sorted()

    for (i in 0 until n) {
        for (j in 0 until n) {
            val target = m - (ks[i] + ks[j])
            if (binarySearch(sum, target)) {
                println("Yes")
                return
            }
        }
    }
    println("No")
}