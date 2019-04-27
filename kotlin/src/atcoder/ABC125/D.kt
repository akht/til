package atcoder.ABC125

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val aa = readLine()!!.split(" ").map { it.toLong() }.toMutableList()

    // 前から2つずつ見ていく
    // ++だったらそのまま
    // +-だったらそのまま
    // -+だったら+-にする
    // --だったら++にする
    // これが終わった後に、全て+になっていればその総和が答え
    // -が残っていた場合、絶対値が最小のものを-にすると決めて総和を求める
    // (与えられた操作によって、その数を-にするかというのは自由に決めることができる)
    // ※コンテスト中はこう考えたが、よくよく考えると
    // 「-の位置を自由に移動できる = -を一箇所に集められる」ということなので
    // ・-の数が偶数なら全て+にできる
    // ・-が数が奇数ならひとつだけ-が残る
    // ということがわかる

    for (i in 0 until n - 1) {
        val f = aa[i]
        val s = aa[i + 1]

        if (f > 0 && s > 0) {

        } else if (f > 0 && s < 0) {

        } else {
            aa[i] = f * -1
            aa[i + 1] = s * -1
        }
    }

    if (aa.all { it > 0 }) {
        println(aa.sum())
    } else {
        var min = Long.MAX_VALUE
        var sum = 0L
        for (i in 0 until n) {
            min = Math.min(min, Math.abs(aa[i]))
            sum += Math.abs(aa[i])
        }

        println(sum - min * 2)
    }
}