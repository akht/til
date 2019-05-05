n, m = gets.strip.split.map(&:to_i)
as = gets.strip.split.map(&:to_i).sort.reverse

ans = 0
as.each do |i|
    m -= i
    ans += 1
    break if m <= 0
end

puts ans