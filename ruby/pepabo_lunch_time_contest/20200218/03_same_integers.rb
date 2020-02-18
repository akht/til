a, b, c = gets.strip.split.map(&:to_i)
min, mid, max = [a, b, c].sort

ans = (max - mid) / 2 + (max - min) / 2

p = [(max - mid) % 2, (max - min) % 2].inject(&:+)
if p == 1
  puts ans + 2
elsif p == 2
  puts ans + 1
else
  puts ans
end
