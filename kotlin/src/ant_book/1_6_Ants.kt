package ant_book

fun main(args: Array<String>) {
    val l = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    val ants = readLine()!!.split(" ").map { it.toInt() }

    // 最小は、すべての蟻が近いほうの端に向かって歩けばよく、その最大値が答え
    // 最大は、蟻たちがぶつかることがあるが、問題文そのままUターンさせる必要はなくて
    // 蟻たちに区別はないわけなのでただお互いが通過すると考えればよい
    // つまりすべての蟻を遠いほうの端まで歩かせたうち、その最大値が答え

    // Pair<左端までの時間, 右端までの時間>
    val dist = ants.map { Pair(it, l - it) }

    // 各蟻が近いほうの端に進んだ時の最大値
    val min = dist.map { Math.min(it.first, it.second) }.max()!!

    // 各蟻が遠いほうの端に進んだ時の最大値
    val max = dist.map { Math.max(it.first, it.second) }.max()!!

    println("min = $min")
    println("max = $max")
}