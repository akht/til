package atcoder.ABC101

fun main(args: Array<String>) {

    val s = readLine()!!

    var count = 0;
    for (c in s) {
        count += if (c == '+') 1 else -1
    }

    println(count)
}