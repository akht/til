package atcoder.snippets

// 2次元空間(グリッド、迷路など)に関するやつ


fun main(args: Array<String>) {

    // 座標を表すデータクラス
    data class Point(var y: Int, var x: Int)

    val row = 0
    val col = 0

    // 二次元リスト
    val grid = (1..row).map { readLine()!!.split("").drop(1).take(col) }

    // 二次元リスト(空白区切りの入力)
    val grid2 = (1..row).map { readLine()!!.split(" ") }

    // 二次元配列(訪問管理など)
    // ※MutableList()はAtCoderでは使えない
    val visited = Array(row) { Array(col) {false} }


    // グリッド上を上下左右に移動
    val d = listOf(0 to 1, 1 to 0, -1 to 0, 0 to -1)

    for ((dy, dx) in d) {
        println("$dy, $dx")
    }


}

// グリッドを出力
fun <T> printGrid(matrix: List<List<T>>) {
    matrix.forEach { println(it.toString()) }
}
