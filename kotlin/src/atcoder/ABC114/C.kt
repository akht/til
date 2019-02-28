package atcoder.ABC114

fun main(args: Array<String>) {
    val N = readLine()!!.toLong()

    println(f(N, 0))
}

fun f(N: Long, x: Long): Int {
    if (N < x) {
        return 0
    }

    var ret = 1
    for (c in "357") {
        if (!x.toString().contains(c.toString())) {
            ret = 0
            break
        }
    }

    for (c in "357") {
        ret += f(N, x * 10 + (c - '0'))
    }

    return ret
}