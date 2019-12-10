x, y = gets.strip.split.map(&:to_i)

count = 0
while x <= y
    count += 1
    x *= 2
end

puts count
