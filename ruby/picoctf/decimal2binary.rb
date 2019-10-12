d = gets.to_i

b = ''
until d <= 1
    b = (d % 2).to_s + b
    d /= 2
end

puts d.to_s + b
