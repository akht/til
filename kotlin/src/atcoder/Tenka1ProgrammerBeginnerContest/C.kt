package atcoder.Tenka1ProgrammerBeginnerContest

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    var xs = (1..n).map { readLine()!!.toLong() }.sorted().reversed()

    if (n % 2 == 0) {
        var ans: Long = 0
        (0 until (n/2 - 1)).forEach { ans += 2 * xs[it] }
        ans += xs[n/2 - 1]
        ans -= xs[n/2]
        ((n/2 + 1) until n).forEach { ans -= 2 * xs[it] }

        println(ans)
    } else {
        var ans1: Long = 0
        (0 until n/2 - 1).forEach { ans1 += 2 * xs[it] }
        ans1 += xs[n/2 - 1] + xs[n/2]
        ((n/2 + 1) until n).forEach { ans1 -= 2 * xs[it] }

        var ans2: Long = 0
        (0 until n/2).forEach { ans2 += 2 * xs[it] }
        ans2 -= xs[n/2] + xs[n/2 + 1]
        ((n/2 + 2) until n).forEach { ans2 -= 2 * xs[it] }

        println(Math.max(ans1, ans2))
    }
}