package atcoder.Tenka1ProgrammerBeginnerContest2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    // 前から#に置き換える
    val s1 = s.split("").drop(1).take(n).toMutableList()
    var ans1 = 0
    for (i in 0 until n - 1) {
        if (s1[i] == "#" && s1[i + 1] == ".") {
            ans1++
            s1[i + 1] = "#"
        }
    }

    // 後ろから.に置き換える
    val s2 = s.split("").drop(1).take(n).toMutableList()
    var ans2 = 0
    for (i in n - 1 downTo 1) {
        if (s2[i - 1] == "#" && s2[i] == ".") {
            ans2++
            s2[i - 1] = "."
        }
    }

    println(Math.min(ans1, ans2))
}