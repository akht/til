package atcoder.ABC093

fun main(args: Array<String>) {
    val s = readLine()!!

    if(s.contains('a') and s.contains('b') and s.contains('c')) {
        println("Yes")
    } else {
        println("No")
    }



    // 別解1
    // allの使い方がキモ
    println(if (s.all { s.indexOf(it) != -1 }) { "Yes" } else { "No" })


    // 別解2
    // ソートして連結した結果を比較する
    if (s.toCharArray().sorted().joinToString("") == "abc") {
        println("Yes")
    } else {
        println("No")
    }

}