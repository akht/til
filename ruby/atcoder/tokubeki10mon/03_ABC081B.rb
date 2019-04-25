_n = gets.to_i
as = gets.strip.split.map(&:to_i)
count = 0
while as.all?(&:even?) do
    count = count.succ
    as = as.map { |a| a / 2 }
end

puts count