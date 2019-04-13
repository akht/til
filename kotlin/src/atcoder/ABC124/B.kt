package atcoder.ABC124

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val hs = readLine()!!.split(" ").map { it.toInt() }

    var ans = 1
    for (i in 1 until n) {
        var taller = false
        for (j in 0..i) {
            if (hs[i] < hs[j]) {
                taller = true
                break
            }
        }
        if (!taller) {
            ans++
        }
    }
    println(ans)
}