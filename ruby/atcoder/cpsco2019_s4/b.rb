n, d = gets.strip.split.map(&:to_i)
s = d.times.map { gets.strip }

ans = 0
d.times do |i|
    (i+1..d-1).each do |j|
        count = 0
        n.times do |k|
            if s[i][k] == 'o' || s[j][k] == 'o'
                count += 1
            end
        end
        ans = [ans, count].max
    end
end

puts ans