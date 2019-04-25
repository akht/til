n, y = gets.strip.split.map(&:to_i)
a, b, c = -1, -1, -1

(0..n).each do |i|
    (0..n-i).each do |j|
        if i * 10000 + j * 5000 + (n - i - j) * 1000 == y
            a, b, c = i, j, n - i - j
        end
    end
end

puts "#{a} #{b} #{c}"