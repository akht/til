package atcoder.ABC109

fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(" ").map(String::toInt)

    val ans = if ((a % 2 != 0) && (b % 2 != 0)) {
        "Yes"
    } else {
        "No"
    }
    println(ans)
}