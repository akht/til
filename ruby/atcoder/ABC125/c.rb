n = gets.to_i
a = gets.split.map(&:to_i)

left_gcd = Array.new(n + 1, 0)
right_gcd = Array.new(n + 1, 0)

(0..n - 1).each do |i|
    left_gcd[i + 1] = left_gcd[i].gcd(a[i])
end

(n - 1).downto(0) do |i|
    right_gcd[i] = right_gcd[i + 1].gcd(a[i])
end

ans = 0
(0..n - 1).each do |i|
    left = left_gcd[i]
    right = right_gcd[i + 1]
    ans = [ans, left.gcd(right)].max
end

puts ans