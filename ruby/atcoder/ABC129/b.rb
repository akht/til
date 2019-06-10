n = gets.strip.to_i
ws = gets.strip.split.map(&:to_i)

sum = ws.inject(:+)

diff = 10 ** 7
(n - 1).times do |i|
    tmp_sum = ws.slice(0, i + 1).inject(:+)
    tmp = (sum - tmp_sum * 2).abs
    diff = [diff, tmp].min
end

puts diff