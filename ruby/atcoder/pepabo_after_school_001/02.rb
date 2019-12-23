o = gets.strip
e = gets.strip

ans = ""
o.chars.each_with_index do |s, idx|
  ans += s
  unless e[idx].nil?
    ans += e[idx]
  end
end

puts ans
