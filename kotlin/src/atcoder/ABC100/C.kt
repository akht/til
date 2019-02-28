package atcoder.ABC100

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map(String::toInt)

    var sum = 0
    for (n in list) {
        var d = n
        var temp = 0
        while (d % 2 == 0) {
            temp++
            d /= 2
        }
        sum += temp
    }
    println(sum)
}

fun main2(args: Array<String>) {
    readLine()  // この値は使わないから空読み
    val nums = readLine()!!.trim().split(' ').sumBy { div2(it.toInt()) }

    println(nums)
}
// 再帰的に2の累乗の指数を求める
fun div2(num:Int):Int {
    return when (num % 2) {
        0 -> 1 + div2(num / 2)
        else -> 0
    }
}