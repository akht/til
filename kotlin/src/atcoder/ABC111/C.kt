package atcoder.ABC111

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val xs = readLine()!!.split(" ").map(String::toInt)

    if (xs.toSet().size == 1) {
        println(n / 2)
        return
    }

    val oddNumList = xs.withIndex().filter { it.index % 2 == 0 }.map { it.value }
    val evenNumList = xs.withIndex().filter { it.index % 2 != 0 }.map { it.value }

    val groupby1 = oddNumList.groupBy { it }.map { it.value }.sortedByDescending { it.size }
    val groupby2 = evenNumList.groupBy { it }.map { it.value }.sortedByDescending { it.size }

    val listOfMax1 = groupby1.first()
    val listOfMax2 = groupby2.first()

    if (listOfMax1.first() != listOfMax2.first()) {
        // oddの数列とevenの数列で最頻値が異なる時は、それをそのまま使う

        val freq1 = listOfMax1.first()
        val freq2 = listOfMax2.first()

        val count1 = groupby1.filter { it[0] != freq1 }.sumBy { it.size }
        val count2 = groupby2.filter { it[0] != freq2 }.sumBy { it.size }

        println(count1 + count2)
        return
    }

    // oddの数列から最頻値をとって、evenの数列から次点最頻値をとるパターン
    val freq1 = listOfMax1.first()
    val freq2 = groupby2[1].first()
    val count1 = groupby1.filter { it[0] != freq1 }.sumBy { it.size }
    val count2 = groupby2.filter { it[0] != freq2 }.sumBy { it.size }
    val ans1 = count1 + count2

    // oddの数列から次点最頻値をとって、evenの数列から最頻値をとるパターン
    val freq3 = groupby1[1].first()
    val freq4 = listOfMax2.first()
    val count3 = groupby1.filter { it[0] != freq3 }.sumBy { it.size }
    val count4 = groupby2.filter { it[0] != freq4 }.sumBy { it.size }
    val ans2 = count3 + count4

    if (ans1 < ans2) {
        println(ans1)
    } else {
        println(ans2)
    }
}