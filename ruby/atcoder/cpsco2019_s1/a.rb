n, a = gets.strip.split.map(&:to_i)

min = (a + 3 - 1) / 3
max = [n / 3, a].min

puts "#{min} #{max}"