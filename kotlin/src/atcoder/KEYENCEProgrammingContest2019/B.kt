package atcoder.KEYENCEProgrammingContest2019

fun main(args: Array<String>) {
    val s = readLine()!!
    val keyence = "keyence"

    if (s.startsWith(keyence) || s.endsWith(keyence)) {
        println("YES")
        return
    }

    for (i in (1..6)) {
        val head = keyence.substring(0, i)
        val tail = keyence.subSequence(i, keyence.length)

        if (s.startsWith(head) && s.endsWith(tail)) {
            println("YES")
            return
        }
    }

    println("NO")
}