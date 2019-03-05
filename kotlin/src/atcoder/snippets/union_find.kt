package atcoder.snippets


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