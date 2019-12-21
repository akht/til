n = gets.to_i
an = gets.strip.split.map(&:to_i)

mod = 10 ** 9 + 7
ans = 0
keta = 1
(0..60).each do |d|
  count = an.count {|a| (a / keta) % 2 == 1}
  ans += count * (n - count) * keta
  ans %= mod
  keta *= 2
end

puts ans
