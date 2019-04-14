package atcoder.ABC124

fun main(args: Array<String>) {
    val (n, k) = readLine()!!.split(" ").map { it.toInt() }
    val s = readLine()!!

    val nums = mutableListOf<Int>()
    var now = 1
    var count = 0
    for (i in 0 until n) {
        if (s[i] == ('0' + now)) {
            count++
        } else {
            nums.add(count)
            now = 1 - now
            count = 1
        }
    }
    if (count != 0) {
        nums.add(count)
    }

    if (nums.size % 2 == 0) {
        nums.add(0)
    }

    val cumsum = Array(n + 1) { 0 }
    for (i in 0 until nums.size) {
        cumsum[i + 1] = cumsum[i] + nums[i]
    }

    val add = 2 * k + 1
    var ans = 0
    for (i in 0 until nums.size step 2) {
        val left = i
        val right = Math.min(i + add, nums.size)
        val tmp = cumsum[right] - cumsum[left]

        ans = Math.max(ans, tmp)
    }
    println(ans)
}
