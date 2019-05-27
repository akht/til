n, m = gets.strip.split.map(&:to_i)
a = gets.strip.split.map(&:to_i)
bc = (0...m).map { gets.strip.split.map(&:to_i) }

bc.each do |b, c|
    b.times { a.push c }
end

a.sort!.reverse!
ans = a.take(n).inject(:+)
puts ans
