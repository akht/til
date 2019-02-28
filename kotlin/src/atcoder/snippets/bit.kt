package atcoder.snippets

// ビット、Ｎ進数に関するやつ


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

// 2進数にしたときの桁数を返す
// 10(10進数) -> 1010(2進数) -> 4(桁)
fun binaryKetasu(n: Long): Int {
    return (Math.log10(n.toDouble()) / Math.log10(2.0) + 1).toInt()
}

