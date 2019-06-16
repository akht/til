n, k = gets.strip.split.map(&:to_i)

if k == 1
    puts 0
else
    puts n - k
end
