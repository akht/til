n, x, y = gets.strip.split.map(&:to_i)
as = gets.strip.split.map(&:to_i).sort.reverse

n.times do |i|
    if i % 2 == 0
        x += as[i]
    else
        y += as[i]
    end
end

if x > y
    puts 'Takahashi'
elsif x < y
    puts 'Aoki'
else
    puts 'Draw'
end