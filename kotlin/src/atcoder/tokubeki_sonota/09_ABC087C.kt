package atcoder.tokubeki_sonota

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val upper = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    val lower = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    // 下には一度しか行けないので、どこで下に行くかで分けて考える
    // 下にいく箇所はN通り

    upper.add(0, 0)
    lower.add(0, 0)

    val upperCumsum = Array(n+1) {0}
    val lowerCumsum = Array(n+1) {0}
    for (i in 1..n) {
        upperCumsum[i] = upperCumsum[i - 1] + upper[i]
        lowerCumsum[i] = lowerCumsum[i - 1] + lower[i]
    }

    var ans = 0
    for (i in 1 .. n) {
        val upperSum = upperCumsum[i]  - upperCumsum[0]
        val lowerSum = lowerCumsum[n]  - lowerCumsum[i - 1]

        ans = Math.max(ans, upperSum + lowerSum)
    }

    println(ans)
}