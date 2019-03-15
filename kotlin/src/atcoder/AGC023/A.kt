package atcoder.AGC023

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map { it.toLong() }


    // まず累積和をとる
    //     S0 = 0
    //     S1 = a1
    //     S2 = a1 + a2
    //     S3 = a1 + a2 + a3
    //     S4 = a1 + a2 + a3 + a4
    // ここで例えば、a2 + a3 の区間を求めたいときは累積和を使ってこうなる
    //     a2 + a3 = (a1 + a2 + a3) - (a1) = S3 - S1
    // そして a2 + a3 = 0 になるとすると
    //     S3 - S1 = 0 <=> S3 = S1
    // つまり、
    //     ある区間の合計が0になる <=> 累積和で同じ値のペアがある
    // 例えば、累積和のなかに4が3つ出現したら、3つのなかから2を選ぶ組み合わせなので
    //     3C2 = 3 * (3 - 1) / 2 = 3通り
    // よって、累積和に現れるすべての値に対して出現回数をチェックして、
    // 2回以上現れるものは組み合わせ数を求めて総和をとればよい
    // ※累積和の0はペアがなくてもそれ自体で条件を満たす区間であることに注意
    // 累積和の最初に0を入れておけば、きれいに計算できる


    // 累積和
    val cumsum = Array(n + 1) { 0L }

    // 同じ値が出現する回数
    val memo = mutableMapOf<Long, Long>()
    memo[0] = 1

    // 累積和を求めつつ、出現回数をメモしていく
    for (i in 0 until an.size) {
        var sum = cumsum[i] + an[i]
        cumsum[i + 1] = sum

        // 出現回数をメモ
        memo[sum] = memo.getOrPut(sum) { 0 } + 1
    }

    // 2回以上現れるものの組み合わせを計算して合計する
    val ans = memo.filter { it.value >= 2 }.map { it.value * (it.value - 1) / 2 }.sum();
    println(ans)
}