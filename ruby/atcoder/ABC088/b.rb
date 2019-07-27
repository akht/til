n = gets.to_i
cards = gets.strip.split.map(&:to_i)

puts cards.sort.map.with_index{|v, i| i.even? ? v : -v}.inject(:+).abs
