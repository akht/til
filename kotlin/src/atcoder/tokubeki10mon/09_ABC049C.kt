package atcoder.tokubeki10mon

fun main(args: Array<String>) {
    var s = readLine()!!

    val list = listOf("dream", "dreamer", "erase", "eraser")

    while (s.isNotEmpty()) {
        var found = false
        for (word in list) {
            if (s.endsWith(word)) {
                s = s.take(s.length - word.length)
                found = true
            }
        }
        if (!found) {
            println("NO")
            return
        }
        found = false
    }

    println("YES")
}