package atcoder.ABC100

fun main(args: Array<String>) {
    val (D, N) = readLine()!!.split(" ").map(String::toInt)

    if (N == 100) {
        println((N+1 * Math.pow(100.0, D.toDouble())).toInt())
    } else {
        println((N * Math.pow(100.0, D.toDouble())).toInt())
    }
}