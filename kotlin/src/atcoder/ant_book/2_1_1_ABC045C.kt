package atcoder.ant_book

fun main(args: Array<String>) {
    val s = readLine()!!

    var ans = 0L
    for (bit in 0 until (1 shl s.length - 1)) {
        var tmp = (s[0] - '0').toLong()
        for (i in 0 until s.length - 1) {
            if (1 and (bit shr i) == 1) {
                ans += tmp
                tmp = (s[i + 1] - '0').toLong()
            } else {
                tmp = tmp * 10 + (s[i + 1] - '0')
            }
        }
        ans += tmp
    }
    println(ans)
}