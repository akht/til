package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!

    val cumsumW = s.map { if (it == 'W') 1 else 0}.toMutableList()
    val cumsumE = s.map { if (it == 'E') 1 else 0}.toMutableList()

    cumsumW.add(0, 0)
    cumsumE.add(0, 0)

    for (i in 1..n) {
        cumsumW[i] += cumsumW[i - 1]
        cumsumE[i] += cumsumE[i - 1]
    }

    var ans = 3 * 10e5.toInt()
    for (i in 1..n) {
        var lhs = cumsumW[i - 1] - cumsumW[0]
        var rhs = cumsumE[n] - cumsumE[i - 1]
        ans = Math.min(ans, lhs + rhs)
    }
    println(ans)


    // これはダメ WAでる
}