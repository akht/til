l, x = gets.strip.split.map(&:to_i)
r = x % (2 * l)
ans = if r < l
    r
else
    2 * l - r
end

puts ans