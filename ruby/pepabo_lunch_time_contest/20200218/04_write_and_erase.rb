n = gets.to_i
an = n.times.map { gets.to_i }

puts an.group_by(&:itself).select { |k, v| v.size.odd? }.count
