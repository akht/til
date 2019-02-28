package atcoder.ABC093

fun main(args: Array<String>) {
    var (max, mid, min) = readLine()!!.split(" ").map { it.toInt() }.sortedDescending()

    var count = 0
    while (max != mid) {
        mid++
        min++
        count++
    }
    
    while (2 <= max - min) {
        min += 2
        count++
    }

    when {
        max - min == 0 -> println(count)
        max - min == 1 -> println(count + 2)
        max - min == -1 -> println(count + 1)
    }
}