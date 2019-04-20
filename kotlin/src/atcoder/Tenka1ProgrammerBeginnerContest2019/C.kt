package atcoder.Tenka1ProgrammerBeginnerContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    // 色を変更する操作を行ったあとの最終形としては
    // 「...###」のように左端から白だけが続いて、ある地点から右端まで黒が続くという形か
    // もしくは「....」や「####」みたいな1色のみにしかならない
    // 【例】
    //    #..# -> ...# = 1回
    //    .#.# -> ...# = 1回
    //    #.#. -> .... or #### = 2回
    // つまり最終形を考えたときに、白から黒に切り替わる境界をどこにするのが最適かを考えればよい
    // 【例】
    //    N=4の時、最終形は以下の5つのどれか
    //      ####
    //      .###
    //      ..##
    //      ...#
    //      ....
    //    この中でどれにするのが最適かを考える
    // 左 left 個が白
    // 右 N - left 個が黒
    // として、leftを全探索する。
    // [0, left)を白にしたい = [0, left)の黒の個数
    // [left, N)を黒にしたい = [left, N)の白の個数
    // なので、あらかじめ累積和を用意しておけば高速に求められる

    // 白と黒の個数の累積和を作る
    val wsum = Array(n + 1) { 0 }
    val bsum = Array(n + 1) { 0 }

    for (i in 0 until n) {
        wsum[i + 1] = wsum[i] + (if (s[i] == '.') 1 else 0)
        bsum[i + 1] = bsum[i] + (if (s[i] == '#') 1 else 0)
    }

    var ans = Int.MAX_VALUE
    for (left in 0..n) {
        var tmp = 0

        // leftを全部白にする
        tmp += bsum[left] - bsum[0]

        // rightを全部黒にする
        tmp += wsum[n] - wsum[left]

        ans = Math.min(ans, tmp)
    }

    println(ans)
}