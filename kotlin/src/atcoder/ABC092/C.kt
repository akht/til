package atcoder.ABC092

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aa = readLine()!!.split(" ").map { it.toLong() }.toMutableList()

    // 計算しやすいように、先頭と末尾に0を置いておく
    aa.add(0, 0)
    aa.add(0)

    // 一箇所も飛ばさなかった場合の金額の総和Sを求めておく
    val s = (0..n).map { Math.abs(aa[it] - aa[it + 1]) }.sum()

    // 観光スポットAiを飛ばさなかった場合、
    // ... -> Ai-1 -> Ai -> Ai+1 -> ...
    // と移動するから、この部分の金額は |Ai-1 - Ai| + |Ai - Ai+1| = X となる
    // もしAiを飛ばした場合は、
    // ... -> Ai-1 -------> Ai+1 -> ...
    // となるので、この部分の金額は |Ai-1 - Ai+1| = Y となる
    // つまりAiを飛ばした時の金額は、一箇所も飛ばさない場合の金額Sから、Xを引いてYを足したものとなる
    // Si = S - (|Ai-1 - Ai| + |Ai - Ai+1|) + |Ai-1 - Ai+1|

    for (i in 1..n) {
        val x = Math.abs(aa[i - 1] - aa[i]) + Math.abs(aa[i] - aa[i + 1])
        val y = Math.abs(aa[i - 1] - aa[i + 1])
        val ans = s - x + y
        println(ans)
    }
}