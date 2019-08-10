a, b, c = gets.strip.split.map(&:to_i)

puts [c - (a - b), 0].max