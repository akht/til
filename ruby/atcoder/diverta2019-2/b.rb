n = gets.strip.to_i
xys = n.times.map { gets.strip.split.map(&:to_i) }

# まず最大コストはN
# そこからいい感じにp, qを選んでどれだけコストを減らせるか？

# 少なくとも、最初の点から適当に次の点を選んで、その(dx, dy)を(p, q)とすれば
# 必ず1はコストを減らすことができる

# つまり全ての点について、お互いの(dx, dy)を調べ、もっとも多い組を(p, q)とすればよい？
# 3点あったとき、上から回収するのと下から回収するのは同じなので(dx, dy)の正負は関係ない
# よって絶対値をとれば良い
# って絶対値とったらダメじゃん！
# (1, 1)と(-1, -1)は同じ(逆向き)だけど、(1, -1)は違うじゃん！アホすぎる

# 最大のN = 50の場合でも、全ての点の(dx, dy)の組み合わせは 50C2 = 1225通りなので余裕で間に合う

# N = 1の時に気をつける

if n == 1
    puts 1
else
    dxdy = []
    xys.combination(2).to_a.map do |c|
        p1, p2 = c
        dx = p1[0] - p2[0]
        dy = p1[1] - p2[1]

        dxdy.push [dx, dy]
        dxdy.push [-dx, -dy]
    end

    count = dxdy.group_by(&:itself).map { |k, v| [v.size, k] }.max_by(&:first)[0]
    puts n - count
end
