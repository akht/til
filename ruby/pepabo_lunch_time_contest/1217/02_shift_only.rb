n = gets.to_i
an = gets.strip.split.map(&:to_i)

ans = 0
while an.all?(&:even?) do
  ans += 1
  an = an.map {|n| n / 2}
end

puts ans
