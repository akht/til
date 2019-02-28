package atcoder.ABC110

fun main(args: Array<String>) {
    val s = readLine()!!
    val t = readLine()!!

    if (s == t) {
        println("Yes")
        return
    }

    var memo1 = mutableMapOf<Char, Char>()
    var memo2 = mutableMapOf<Char, Char>()
    for (i in (0 until s.length)) {
        var cs = s[i]
        var ts = t[i]

        if (memo1.containsKey(cs)) {
            if (memo1[cs] != ts) {
                println("No")
                return
            }
        } else {
            memo1[cs] = ts
        }

        if (memo2.containsKey(ts)) {
            if (memo2[ts] != cs) {
                println("No")
                return
            }
        } else {
            memo2[ts] = cs
        }
    }

    println("Yes")
}