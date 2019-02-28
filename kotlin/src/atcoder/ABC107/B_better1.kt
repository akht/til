package atcoder.ABC107

fun main(args: Array<String>) {
    val (h, w) = readLine()!!.split(" ").map(String::toInt)
    val inputs = (0 until h).map { readLine()!! }

    var newMap: List<String>
    newMap  = inputs.filter { it.contains("#") }.toList()
    newMap = (0 until w)
            .filter { v -> newMap.any { s -> s[v] == '#' } }
            .let { indexes ->
                newMap.map { str -> str.filterIndexed { index, _ -> indexes.contains(index) } }
            }

    newMap.forEach { println(it) }
}