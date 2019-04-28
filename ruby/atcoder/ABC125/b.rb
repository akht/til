n = gets.to_i
vs = gets.split.map(&:to_i)
cs = gets.split.map(&:to_i)

puts (0..n-1).map {|i| [vs[i] - cs[i], 0].max }.inject(:+)