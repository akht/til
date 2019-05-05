n = gets.strip.to_i
st = n.times.map { gets.strip.split.map(&:to_i) }.sort_by { |f, s| f }

# 区間が重なり合っているところをグループとみなしたとき
# 区間全体は何グループに分かれるか？

# 区間の始点でソートする
# これまでに出てきた区間の終点の最大値を覚えておき、
# 次に出てきた区間の始点がそれより大きければカウントしていく

ans = 0
terminal = 0
(0..n-1).each do |i|
    if terminal < st[i][0]
        ans += 1
    end
    terminal = [terminal, st[i][1]].max
end

puts ans