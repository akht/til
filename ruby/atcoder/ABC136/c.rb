n = gets.to_i
hs = gets.strip.split.map(&:to_i)

# 右から見ていって、自分より右側にあるものの最小値を覚えておく
# 自分を1下げた時、自分より右側に自分より小さいものがあればダメ

arr = []
min = 10 ** 10

hs.each_with_index.reverse_each do |v, i|
    min = v if min > v
    arr << min
end

arr.reverse!

puts hs.each_with_index.map {|v, i| v - 1 <= arr[i]}.all? ? "Yes" : "No"