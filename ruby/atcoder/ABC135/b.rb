n = gets.to_i
ps = gets.strip.split.map(&:to_i)

puts ps.select.with_index{|v, i| i + 1 != v}.count <= 2 ? "YES" : "NO"
