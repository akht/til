a, b, c, x = 4.times.map { gets.to_i }
count = 0
(0..a).each do |i|
    (0..b).each do |j|
        (0..c).each do |k|
            count += 1 if i * 500 + j * 100 + k * 50 == x
        end
    end
end

puts count