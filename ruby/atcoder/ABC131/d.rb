n = gets.strip.to_i
ab = n.times.map { gets.strip.split.map(&:to_i) }

# 〆切が近いものからやっていく
ab = ab.sort_by { |a, b| b }

now = 0
ans = 'Yes'
ab.each do |a, b|
    now += a
    if b < now
        ans = 'No'
        break
    end
end

puts ans