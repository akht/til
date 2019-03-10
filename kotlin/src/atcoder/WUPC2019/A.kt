package atcoder.WUPC2019

fun main(args: Array<String>) {

    // これTLE


    var s = readLine()!!

    var ans = ""
    var buf = ""
    for (c in s) {
        if (c != 'W' && c != 'A') {
            buf += c.toString()
            ans += buf
            buf = ""
            continue
        }

        if (c == 'W') {
            buf += "W"
            continue
        }

        if (c == 'A') {
            if (buf.isEmpty()) {
                buf += "A"
                ans += buf
                buf = ""
                continue
            } else {
                var tmp = ""
                for (i in buf) {
                    tmp += "C"
                }
                buf = "A" + tmp
                ans += buf
                buf = ""
            }
        }
    }
    ans += buf
    println(ans)
}