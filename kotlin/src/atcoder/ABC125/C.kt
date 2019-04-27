package atcoder.ABC125

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val a = readLine()!!.split(" ").map { it.toLong() }

    // ある数を除いた残りの数列のgcdがそのまま最適gcdになる
    // 全ての数について、それを除いた残りの数列のgcdを求めるとTLEなので
    // あらかじめgcdを求めておく必要があるが
    // gcdだと通常の累積和のようなことができない
    // (sum[right] - sum[left]のようなことができない)
    // そこで左からの累積gcdと右からの累積gcdを両方持っておいて
    // 除く数の位置で分割した二つの累積gcdのgcdを取ればよい
    // その最大値が求める答え

    val leftGcd = Array(n + 1) { 0L }
    val rightGcd = Array(n + 1) { 0L }

    for (i in 0 until n) {
        leftGcd[i + 1] = gcd(leftGcd[i], a[i])
    }

    for (i in n - 1 downTo 0) {
        rightGcd[i] = gcd(rightGcd[i + 1], a[i])
    }

    var ans = 0L
    for (i in 0 until n) {
        val left = leftGcd[i]
        val right = rightGcd[i + 1]
        ans = Math.max(ans, gcd(left, right))
    }

    println(ans)
}

fun gcd(a: Long, b: Long): Long {
    if (b == 0L) return a

    return gcd(b, a % b)
}
