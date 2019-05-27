a, b = gets.strip.split.map(&:to_i)

if a <= 5
  puts 0
elsif a <= 12
  puts b / 2
else
  puts b
end
