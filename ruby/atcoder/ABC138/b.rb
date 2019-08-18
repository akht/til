n = gets.to_i
an =  gets.strip.split.map(&:to_i)

tmp = 0
an.each do |a|
    tmp += 1.0 / a
end

puts 1.0 / tmp