a, b, c = gets.strip.split.map(&:to_i)

puts (1..b).any? {|i| i * a % b == c} ? "YES" : "NO"
