package bit_practice

import kotlin.test.assertEquals

fun main(args: Array<String>) {

    // 10進数を2進数に変換

    var n = 3

    val expected = Integer.toBinaryString(n)
    val actual = toBinaryString(n.toLong())

    assertEquals(expected, actual)
}

// 10進数を2進数文字列にして返す
fun toBinaryString(n: Long): String {
    var m = n
    var binaryString = ""
    while (0 < m) {
        binaryString = (n % 2).toString() + binaryString
        m /= 2
    }
    return binaryString
}
