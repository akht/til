package atcoder.snippets

// bit全探索

fun main(args: Array<String>) {

    // "abc"の部分文字列を列挙する

    val s = "abc"
    val len = s.length

    for (bit in 0 until (1 shl len)) {
        var substring = ""
        for (i in 0 until len) {
            if (1 and (bit shr i) == 1) {
                substring += s[i]
            }
        }
        println(substring)
    }

}