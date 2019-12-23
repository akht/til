a, b, c = gets.strip.split.map(&:to_i)

puts [a, b, c].combination(2).to_a.map {|a| a.first + a.last}.min
