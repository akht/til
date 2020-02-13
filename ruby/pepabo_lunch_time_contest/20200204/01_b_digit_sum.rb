n = gets.strip.to_i
sn = n.to_s.chars.map(&:to_i).inject(:+)

puts n % sn == 0 ? 'Yes' : 'No'
