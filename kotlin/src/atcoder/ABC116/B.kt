package atcoder.ABC116

fun main(args: Array<String>) {
    val s = readLine()!!.toInt()

    fun fn(n: Int): Int = if (n % 2 == 0) n / 2 else 3 * n + 1

    val list = mutableListOf(s)
    for (m in 2..1000000) {
        val am = fn(list.last())
        if (list.contains(am)) {
            println(m)
            return
        }
        list.add(am)
    }
}
