n, a, b = gets.strip.split.map(&:to_i)
d = b.zero? ? [] : gets.strip.split.map(&:to_i).sort

d = [0] + d + [n + 1]
ans = n - b
(b + 1).times do |i|
    ans -= (d[i + 1] - d[i] - 1) / a
end

puts ans