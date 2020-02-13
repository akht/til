n, k = gets.strip.split.map(&:to_i)
an = gets.strip.split.map(&:to_i)

count = an.group_by(&:itself).map{ |key, value| value.size }.sort.reverse
puts count.size > k ? n - count.take(k).inject(:+) : 0
