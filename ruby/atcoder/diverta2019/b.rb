r, g, b, n = gets.strip.split.map(&:to_i)

ans = 0
(0..n).each do |i|
    (0..n).each do |j|
        rest = n - (r * i + g * j)
        if rest >= 0 && rest % b == 0 && rest / b <= 3000
            ans += 1
        end
    end
end

puts ans