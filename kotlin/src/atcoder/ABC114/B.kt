package atcoder.ABC114

fun main(args: Array<String>) {
    val s = readLine()!!

    var d = Int.MAX_VALUE
    for ((i, c) in s.withIndex()) {
        if (s.length - 3 < i) {
            break
        }
        val a = s.substring(i, i+3).toInt()
        d = Math.min(d, Math.abs(753 - a))
    }

    println(d)
}