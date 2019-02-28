package atcoder.snippets

/**
 * 順列
 */

fun main(args: Array<String>) {

    var list = permutations(mutableListOf(1, 2, 3))
    for (p in list) {
        println(p)
    }

}

fun <T> permutations(input: List<T>): List<List<T>> {
    if (input.size == 1) {
        return listOf(input)
    }

    val perms = mutableListOf<List<T>>()
    val toInsert = input[0]
    for (perm in permutations(input.drop(1))) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, toInsert)
            perms.add(newPerm)
        }
    }

    return perms
}