n, l = gets.strip.split.map(&:to_i)

# 総和から一番絶対値が小さいものを除けばよい

apples = n.times.map { |i| l + i }
sum = apples.inject(:+)
min = apples.min_by { |a| a.abs }

puts sum - min