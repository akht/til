package atcoder.ABC109

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val words = (0 until n).map { readLine()!! }

    if (words.toSet().size != words.size) {
        println("No")
        return
    }

    var end = words[0].first()
    for (word in words) {
        if (end != word.first()) {
            println("No")
            return
        }
        end = word.last()
    }

    println("Yes")
}