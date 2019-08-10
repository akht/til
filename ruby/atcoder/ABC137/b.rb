k, x = gets.strip.split.map(&:to_i)

puts ([-1000000, x - (k - 1)].max .. [1000000, x + (k - 1)].min).to_a.join(' ')