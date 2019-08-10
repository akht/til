package atcoder.ABC137

fun main() {
    val n = readLine()!!.toInt()
    val ss = (1..n).map { readLine()!! }

    // アナグラムである = 文字列中の文字をソートした結果が一致する

    // すべてのsをソートして、同じものが何回登場するかで組み合わせの数がわかるので
    // それらの総和が答え

    fun comb(n: Int, r: Int): Int {
        if (r == 0) {
            return 1
        }

        return (n - r + 1) * comb(n, r - 1) / r
    }

    val ans = ss.map { it.toCharArray().sorted().joinToString("") }
                .groupingBy { it }.eachCount()
                .values
                .map { comb(it, 2) }.sum()

    print(ans)
}