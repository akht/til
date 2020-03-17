n = gets.to_i
lrs = n.times.map { gets.strip.split.map(&:to_i) }

puts lrs.map {|l, r| r - l + 1}.inject(:+)
