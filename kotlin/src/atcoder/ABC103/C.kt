package atcoder.ABC103

fun main(args: Array<String>) {
    val n = readLine()!!
    val xs = readLine()!!.split(" ").map(String::toInt)

    // mについての制限はないので、
    // 各項の余りが最大(Ai-1)になるようなmを選んだとすればよい
    // ちなみに、そのようなmのうちのひとつには、各項の総乗から-1したものがある
    // つまり、各項の余りの最大値はAi-1なのでそれらの総和が答えになる

    println(xs.map { it - 1 }.sum())
}