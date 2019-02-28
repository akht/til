package atcoder.ABC101

fun main(args: Array<String>) {
    val k = readLine()!!.toLong()


}

fun calc(l: Long): Double {
    return l.toDouble().div(digitSum(l))
}

fun digitSum(l: Long): Int {
    return l.toString().sumBy { it - '0' }
}