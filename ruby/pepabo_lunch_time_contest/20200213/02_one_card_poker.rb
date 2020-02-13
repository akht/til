a, b = gets.strip.split.map(&:to_i).map {|n| n == 1 ? 1000 : n}

if a > b
  puts 'Alice'
elsif a < b
  puts 'Bob'
else
  puts 'Draw'
end
