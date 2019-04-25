a, b = gets.strip.split.map(&:to_i)
puts (a * b).odd? ? 'Odd' : 'Even'