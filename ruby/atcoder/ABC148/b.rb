n = gets.to_i
s, t = gets.strip.split()

ans = ""
n.times do |i|
  ans += s[i] + t[i]
end

puts ans
