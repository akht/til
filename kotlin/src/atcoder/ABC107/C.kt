package atcoder.ABC107

fun main(args: Array<String>) {

    // ろうそくをK本含む区間を考える
    // 区間の始端または終端が0をまたがない場合は、先端まで行くのにかかるタイムが答え
    // 終端または始端が0をまたぐ場合は、
    // 右にいってから左に行く場合と、左にいってから右に行く場合の２通りを比較して
    // 小さいほうをその区間のタイムと考える
    // 右にいってから左に行く場合は、右の区間のタイムを２倍して
    // 左にいってから右に行く場合は、左の区間のタイムを２倍することに注意

    val (N, K) = readLine()!!.split(" ").map { it.toInt() }
    val xs = readLine()!!.split(" ").map { it.toLong() }

    var ans = (0 .. xs.size - K)
            .map { Pair(it, it + K - 1) }
            .map {
                if (xs[it.second] <= 0 || 0 <= xs[it.first]) {
                    // 0をまたがない場合
                    Math.max(Math.abs(xs[it.first]), Math.abs(xs[it.second]))
                } else {
                    // 0をまたぐ場合
                    // →にいってから戻って←に行くとき
                    var time1 = xs[it.second] * 2 + Math.abs(xs[it.first])
                    // →にいってから戻って←に行くとき
                    var time2 = Math.abs(xs[it.first]) * 2 + xs[it.second]
                    Math.min(time1, time2)
                }
            }
            .min()

    println(ans)
}