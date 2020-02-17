a, b, c = gets.strip.split.map(&:to_i)
x = gets.strip

x.chars.each do |i|
  case i
  when 'S'
    a = [a - 1, 0].max
  when 'C'
    b = [b - 1, 0].max
  else
    if a > b
      a = [a - 1, 0].max
    elsif a < b
      b = [b - 1, 0].max
    elsif a >= 1 && a == b
      a -= 1
    end
  end
end

puts a
puts b
