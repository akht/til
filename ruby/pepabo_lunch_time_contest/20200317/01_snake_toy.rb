n, k = gets.strip.split.map(&:to_i)
ls = gets.strip.split.map(&:to_i).sort.reverse

puts ls.take(k).inject(:+)
