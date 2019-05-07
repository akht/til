n, d = gets.strip.split.map(&:to_i)
rs = gets.strip.split.map(&:to_i).sort

rs.push(2 * 10 ** 9)

ans = 0
(0..n - 3).each do |i|
    j = rs.bsearch_index { |k| k > rs[i] + d }
    ans += (j - i - 1) * (j - i - 2) / 2
end

puts ans