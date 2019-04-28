n = gets.to_i
as = gets.split.map(&:to_i)

count = as.count { |i| i < 0 }
to_abs = as.map { |e| e.abs }

if count.even?
    puts to_abs.reduce(:+)
else
    min = to_abs.min
    puts to_abs.reduce(:+) - min * 2
end