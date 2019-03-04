package atcoder.ABC120

fun main(args: Array<String>) {
    val s = readLine()!!
    val red = s.filter { it == '0' }.count()
    val blue = s.length - red
    println(Math.min(red, blue) * 2)
}