package atcoder.ABC116

fun main(args: Array<String>) {
    var n = readLine()!!.toInt()
    var hs = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

    println(solve(hs))
}

fun solve(list: MutableList<Int>): Int {
    if (list.size <= 2) {
        return list.max()!!
    }

    var count = 0
    if (list.all { it > 0 }) {
        while (true) {
            if (list.all { it > 0 }) {
                for (i in 0 until list.size) {
                    list[i] = list[i] - 1
                }
                count++
            } else {
                break
            }
        }
    }


    var sublists = mutableListOf<MutableList<Int>>()
    var sublist = mutableListOf<Int>()
    for (h in list) {
        if (h == 0) {
            if (!sublist.isEmpty()) {
                sublists.add(sublist)
            }
            sublist = mutableListOf()
        } else {
            sublist.add(h)
        }
    }
    if (!sublist.isEmpty()) {
        sublists.add(sublist)
    }

    var ans = count
    for (sublist in sublists) {
        ans += solve(sublist)
    }

    return ans
}