s = gets.strip

if s.chars.select { |c| c == 'x' }.count >= 8
    puts "NO"
else
    puts "YES"
end
