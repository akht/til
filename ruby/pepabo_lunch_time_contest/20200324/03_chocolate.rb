n = gets.to_i
d, x = gets.strip.split.map(&:to_i)
an = n.times.map { gets.to_i }

puts an.map {|a| 1 + ((d - 1) / a).ceil}.inject(:+) + x
