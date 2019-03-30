package atcoder.exawizards2019

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = readLine()!!
    val red = s.filter { it == 'R' }.count()
    val blue = n - red
    if (red > blue) {
        println("Yes")
    } else {
        println("No")
    }
}