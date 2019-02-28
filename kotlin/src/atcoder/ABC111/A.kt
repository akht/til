package atcoder.ABC111

fun main(args: Array<String>) {
    val n = readLine()!!

    var ans = ""
    for (d in n) {
        ans += when (d) {
            '1' -> "9"
            '9' -> "1"
            else -> d
        }
    }

    println(ans)
}