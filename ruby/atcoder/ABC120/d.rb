class UnionFind
    def initialize(size)
        @parent = Array.new(size, -1)
    end

    def root(x)
        if @parent[x] < 0
            x
        else
            @parent[x] = root(@parent[x])
        end
    end

    def same_parent?(x, y)
        root(x) == root(y)
    end

    def merge(x, y)
        x_root = root(x)
        y_root = root(y)

        return false if x_root == y_root

        # merge technique
        if @parent[x_root] > @parent[y_root]
            x_root, y_root = y_root, x_root
        end

        @parent[x_root] += @parent[y_root]
        @parent[y_root] = x_root

        return true
    end

    def size(x)
        return -@parent[root(x)]
    end
end


def solve()
    n, m = gets.strip.split.map(&:to_i)
    abs = m.times.map { gets.strip.split.map(&:to_i) }.reverse

    ans = []
    uf = UnionFind.new(n)

    # 不便さ
    cur = (n * (n - 1)) / 2

    # 逆順にみていく(辺がない状態から辺を足していく)
    abs.each do |ab|
        ans.push(cur)

        a = ab.first - 1
        b = ab.last - 1

        # 同じ連結成分なら不便さは変わらない
        next if uf.same_parent?(a, b)

        # aとbをつなげると、
        # それぞれが属する連結成分の大きさをかけた数だけ行き来できるルートが増えるので
        # そのぶん不便さが減る
        size_a = uf.size(a)
        size_b = uf.size(b)
        cur -= size_a * size_b

        uf.merge(a, b)  # aとbをつなげる
    end

    ans.reverse.each { |a| puts a }
end


solve()
