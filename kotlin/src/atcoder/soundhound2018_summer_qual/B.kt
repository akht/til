package atcoder.soundhound2018_summer_qual

fun main(args: Array<String>) {
    val s = readLine()!!
    val w = readLine()!!.toInt()

    var ans = ""
    for (i in 0 until s.length step w) {
        ans += s[i]
    }
    println(ans)
}