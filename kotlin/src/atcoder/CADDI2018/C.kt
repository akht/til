package atcoder.CADDI2018

fun main(args: Array<String>) {
    val (n, p) = readLine()!!.split(" ").map { it.toLong() }

    var ans = 1L
    var d = Math.ceil(Math.pow(p.toDouble(), 1.0/n.toDouble())).toLong()
    for (i in d downTo 1) {
        if (p % i != 0L) {
            continue
        }

        var x = Math.ceil(Math.pow(i.toDouble(), n.toDouble())).toLong()
        if (p % x == 0L) {
            ans = i
            break
        }
    }
    println(ans)
}