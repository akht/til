package training

fun main(args: Array<String>) {

//    あなたはよくA駅やB駅から電車に乗ります。A駅～J駅まであり、行先は様々ですが運賃は駅間ごとに決まっています。
//
//    ある日の駅間ごとの運賃は以下の通りでした。
//
//    A駅～B駅：118円
//    B駅～C駅：191円
//    C駅～D駅：410円
//    D駅～E駅：598円
//    E駅～F駅：129円
//    F駅～G駅：493円
//    G駅～H駅：334円
//    H駅～I駅：357円
//    I駅～J駅：432円
//    さて、ここで問題です。A駅からG駅まで行くための運賃は何円でしょうか？ また、B駅からI駅まで行くための運賃は何円でしょうか？

    // 区間ごとの運賃のリスト
    val unchin = listOf(118, 191, 410, 598, 129, 493, 334, 357, 432)


    // A駅からG駅に行く運賃と、B駅からI駅まで行くための運賃を求める
    // ふつうに考えると、A駅からG駅までにかかる運賃を合計する
    val A_to_G = unchin.subList(0, 6).sum()
    println(A_to_G)

    val B_to_I = unchin.subList(1, 8).sum()
    println(B_to_I)

    // ↑これはN個の区間があれば、その分だけ加算を行わないといけないので駅の数・求める運賃の数が多くなると時間がかかる
    // たとえば駅が1000万駅あると、平均500万回、最悪で1000万回の計算が毎回(!)必要になってしまう

    println("------------------------------------------------------------")


    // ★ここで累積和の考えを導入する

    // 始点(A駅)からすべての駅までの運賃をあらかじめ計算してもっておく
    // これにはN駅あればO(N)かかる ※1000万駅あれば1000万回
    val cumsum = (1..unchin.size).map { unchin.take(it).sum() }
    // => [118, 309, 719, 1317, 1446, 1939, 2273, 2630, 3062]
    println(cumsum)

    val A_to_G_2 = cumsum[5]
    println(A_to_G_2)

    val B_to_I_2 = cumsum[7] - cumsum[0]    // A-Iまでの運賃からA-Bまでの運賃を引く
    println(B_to_I_2)


    println("------------------------------------------------------------")

    // ★番兵をつかって書いてもいい

    // 区間ごとの運賃のリスト
    val unchin_sentinels = listOf(0, 118, 191, 410, 598, 129, 493, 334, 357, 432)
    val cumsum_sentinels = (1..unchin_sentinels.size).map { unchin_sentinels.take(it).sum() }
    println(cumsum_sentinels)

    fun sum(a: Int, b: Int): Int = if (a >= b) 0 else cumsum_sentinels[b] - cumsum_sentinels[a - 1]

    val A_to_G_3 = sum(1, 6)
    println(A_to_G_3)

    val B_to_I_3 = sum(2, 8)    // A-Iまでの運賃からA-Bまでの運賃を引く
    println(B_to_I_3)



    println("------------------------------------------------------------")

    // ★ただし、累積和も万能ではない
    // 区間の値の書き換えが生じた場合、全区間の書き換えが必要になるためO(N)かかる
    // たとえば運賃が10円値上がりしたら、1000万駅あれば1000万区間の運賃を書き換えなければならない

    // ★これを解決するのがBinary Indexed Tree(通称BIT)

    
}