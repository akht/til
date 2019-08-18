n, q = gets.strip.split.map(&:to_i)
ab = (n - 1).times.map { gets.strip.split.map(&:to_i) }
px = q.times.map { gets.strip.split.map(&:to_i) }

# 双方向の辺をもっておく
$to = Array.new(n) { Array.new }

ab.each do |a, b|
    a -= 1
    b -= 1
    $to[a] << b
    $to[b] << a
end

$ans = Array.new(n, 0)

# あとで累積和をとる
px.each do |p, x|
    p -= 1
    $ans[p] += x
end

# dfsで累積和を計算する
def dfs(v, p = -1)
    $to[v].each do |u|
        next if u == p
        $ans[u] += $ans[v]
        dfs(u, v)
    end
end

dfs(0)

puts $ans.join(" ")