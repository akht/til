package atcoder.ABC121

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map { it.toLong() }

    println(f(a - 1) xor f(b))
}

fun f(n: Long): Long {
    val q = (n + 1) / 2
    val r = (n + 1) % 2
    return if (r == 0L) {
        if (q % 2 == 0L) 0 else 1
    } else {
        if (q % 2 == 0L) n else 1L xor n
    }
}
