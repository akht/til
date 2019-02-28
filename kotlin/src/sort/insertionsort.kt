package sort

fun main(args: Array<String>) {

    var list = mutableListOf(4, 2, 1)

    insertionSort(list)

    println(list)
}

// 挿入ソート O(n^2)
fun insertionSort(list: MutableList<Int>) {
    // 2つめの要素から順にみていく
    for (i in 1 until list.size) {
        // 挿入したい値
        val target = list[i]
        println(target)

        // 挿入したい値と同じ位置から、先頭に向かって見ていく
        // あとでjのインデックスを使って挿入するのでfor文の外側で宣言しておく
        var j = i
        while (j > 0) {
            println("j = $j")
            val pre = list[j - 1]
            if (target < pre) {
                // 挿入したい値より大きければひとつ後ろにずらす
                // = ずらすことで後でtargetを挿入するための場所を作っている
                list[j] = pre
                println(list)
            } else {
                // 小さければ終わり
                break
            }
            j--
        }
        // ずらし終わってできたスキマに目的の値を挿入
        list[j] = target;
    }
}