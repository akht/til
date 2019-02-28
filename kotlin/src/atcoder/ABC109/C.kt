package atcoder.ABC109

fun main(args: Array<String>) {
    val (n, x) = readLine()!!.split(" ").map(String::toInt)
    val absset = readLine()!!.split(" ").map(String::toInt).map { Math.abs(it - x) }.toSet()

    val ans = absset.reduce { a, b -> gcd(a, b) }
    println(ans)
}

var memo: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()
fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a

    val pair = Pair(b, a % b)
    return if (memo.containsKey(pair)) {
        memo[pair]!!
    } else {
        val r = gcd(b, a % b)
        memo[pair] = r
        r
    }
}