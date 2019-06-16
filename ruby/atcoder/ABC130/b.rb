n, x = gets.strip.split.map(&:to_i)
ls = gets.strip.split.map(&:to_i)

ans = 1
now = 0
ls.each do |i|
    now += i
    break if x < now
    ans += 1
end

puts ans
