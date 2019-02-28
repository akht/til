package atcoder.ABC111

fun main(args: Array<String>) {
    val n = readLine()!!

    val f = n.first().toString()
    val z = f.repeat(3)

    val ans = if (n.toInt() <= z.toInt()) {
        z
    } else {
        (f.toInt() + 1).toString().repeat(3)
    }

    println(ans)
}