a, b = gets.strip.split.map(&:to_i)

if (b - a).abs % 2 == 0
    puts (b - a).abs / 2 + [a, b].min
else
    puts "IMPOSSIBLE"
end
