a, b = gets.strip.split.map(&:to_i)

puts (a % 3 == 0 || b % 3 == 0 || (a + b) % 3 == 0) ? 'Possible' : 'Impossible'
