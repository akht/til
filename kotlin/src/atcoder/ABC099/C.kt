package atcoder.ABC099

fun main(args: Array<String>) {
    var N = readLine()!!.toInt()


    // 「大きいほうから引いていく」の貪欲法じゃだめ
    // （例）12円のとき
    //  最大の9円を引いてしまうと、残りは1円を3回引かないといけないので結果4回かかる
    //  6円6円とひけば2回ですむ

    // N円のときの求める最小回数をdp[N]として考える
    //    dp[0] = 0
    //    dp[N] = min( 1 + dp[N-1], 1 + dp[N-6], 1 + dp[N-9], 1 + dp[N-36], 1 + dp[N-81], ... )
    // dp[N]のひとつ前の状態というのは、
    // 1円、6円、9円、6^2円、9^2円、、、(N円より小さい6か9のべき乗円)しかない(引き出せる金額の選択肢がそれしかないので)
    // それらの遷移元から遷移してきたときのいくつかのパターンのなかで最小になったものがdp[N]のときの最小回数となる


    var dp = Array(110000) {N}
    dp[0] = 0

    for (i in 1..N) {
        var pow6 = 1
        while (pow6 <= i && pow6 <= N) {
            dp[i] = Math.min(dp[i], 1 + dp[i - pow6])
            pow6 *= 6
        }

        var pow9 = 1
        while (pow9 <= i && pow9 <= N) {
            dp[i] = Math.min(dp[i], 1 + dp[i - pow9])
            pow9 *= 9
        }
    }

    println(dp[N])
}