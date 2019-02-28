package binary_search

import kotlin.test.assertEquals

fun main(args: Array<String>) {

    val a = listOf(10, 11, 13, 13, 15)

    assertEquals(0, lowerBound(a, 9))
    assertEquals(0, lowerBound(a, 10))
    assertEquals(1, lowerBound(a, 11))
    assertEquals(2, lowerBound(a, 12))
    assertEquals(2, lowerBound(a, 13))
    assertEquals(4, lowerBound(a, 14))
    assertEquals(4, lowerBound(a, 15))
    assertEquals(5, lowerBound(a, 16))




    val inf = 1 shl 10
    val list = listOf(-inf, 0, 10, 20, 20, 20, 20, 20, 30, 40, 40, 50, inf)

    assertEquals(1, upperBound(list, -100))
    assertEquals(3, upperBound(list, 10))
    assertEquals(8, upperBound(list, 20))
    assertEquals(9, upperBound(list, 30))
    assertEquals(11, upperBound(list, 40))
    assertEquals(12, upperBound(list, 50))
    assertEquals(12, upperBound(list, 100))
    assertEquals(13, upperBound(list, inf + 1))
}

// lower_bound(めぐる式)
private fun <T: Comparable<T>> lowerBound(list: List<T>, target: T): Int {

    fun isOk(key: Int, target: T): Boolean = target <= list[key]

    var ng = -1
    var ok = list.size
    while (Math.abs(ok - ng) > 1) {
        val mid = (ok + ng) / 2
        if (isOk(mid, target)) {
            ok = mid
        } else {
            ng = mid
        }
    }
    return ok
}

// upper_bound(めぐる式)
private fun <T: Comparable<T>> upperBound(list: List<T>, target: T): Int {

    fun isOk(key: Int, target: T): Boolean = target < list[key]

    var ng = -1
    var ok = list.size
    while (Math.abs(ok - ng) > 1) {
        val mid = (ok + ng) / 2
        if (isOk(mid, target)) {
            ok = mid
        } else {
            ng = mid
        }
    }
    return ok
}