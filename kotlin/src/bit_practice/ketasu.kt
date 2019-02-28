package bit_practice

fun main(args: Array<String>) {

    // 10進数を2進数にしたときの桁数
    println(binaryKetasu(7))
    println(binaryKetasu(1000000000000))

}

fun binaryKetasu(n: Long): Int {
    return (Math.log10(n.toDouble()) / Math.log10(2.0) + 1).toInt()
}