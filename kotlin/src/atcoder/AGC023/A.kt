package atcoder.AGC023

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val an = readLine()!!.split(" ").map { it.toLong() }

    // 愚直解 O(n^2)
    var ans = 0
    for (i in 0 until an.size) {
        var sum = an[i]
        if (sum == 0L) {
            ans++
        }
        for (j in i + 1 until an.size) {
            sum += an[j]
            if (sum == 0L) {
                ans++
            }
        }
    }
    println(ans)
}