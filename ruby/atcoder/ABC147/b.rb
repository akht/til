s = gets.strip

len = s.size
ans = 0
(len / 2).times do |i|
  unless s[i] == s[len - 1 - i]
    ans += 1
  end
end

puts ans
