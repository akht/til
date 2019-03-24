package atcoder.ABC122

fun main(args: Array<String>) {
    val s= readLine()!!

    var ACGT = listOf('A', 'C', 'G', 'T')

    var ans = 0
    for (i in 0 until s.length) {
        if (!ACGT.contains(s[i])) {
            continue
        }
        var len = 0
        for (j in i until s.length) {
            if (ACGT.contains(s[j])) {
                len++
            } else {
                break
            }
        }
        ans = Math.max(ans, len)
    }
    println(ans)
}