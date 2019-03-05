package atcoder.ABC120

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val list = (1..m).map { readLine()!!.split(" ").map { it.toInt() } }.reversed()

    val ans = mutableListOf<Long>()
    val uf = UnionFind(n)

    // 不便さ
    var cur = (n.toLong() * (n.toLong() - 1)) / 2

    // 逆順にみていく(辺がない状態から辺を足していく)
    for (ab in list) {
        ans.add(cur)

        val a = ab[0] - 1
        val b = ab[1] - 1

        // 同じ連結成分なら不便さは変わらない
        if (uf.isSame(a, b)) {
            continue
        }

        // aとbをつなげると、それぞれが属する連結成分の大きさをかけた数だけ行き来できるルートが増えるので
        // そのぶん不便さが減る
        val sizeA = uf.size(a)
        val sizeB = uf.size(b)
        cur -= sizeA * sizeB

        uf.merge(a, b)  // aとbをつなげる
    }

    ans.reversed().forEach{ println(it) }
}

private class UnionFind(n: Int) {
    val parent = Array(n) { -1 }

    fun root(x: Int): Int {
        return if (parent[x] < 0) {
            x
        } else {
            parent[x] = root(parent[x])
            parent[x]
        }
    }

    fun isSame(x: Int, y: Int): Boolean {
        return root(x) == root(y)
    }

    fun merge(x: Int, y: Int): Boolean {
        var xRoot = root(x)
        var yRoot = root(y)
        if (xRoot == yRoot) {
            return false
        }

        // merge technique
        if (parent[xRoot] > parent[yRoot]) {
            val tmp = yRoot
            yRoot = xRoot
            xRoot = tmp
        }

        parent[xRoot] += parent[yRoot];
        parent[yRoot] = xRoot
        return true
    }

    fun size(x: Int): Int {
        return -parent[root(x)]
    }
}
