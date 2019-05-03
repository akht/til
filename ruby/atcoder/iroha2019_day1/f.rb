require 'prime'

n, k = gets.strip.split.map(&:to_i)

factors = n.prime_division.map { |f, c| [f] * c }.reduce([], :+)
if factors.size < k
    puts -1
else
    head = factors[0, k - 1]
    puts (head + [n / head.reduce(1, :*)]).join(' ')
end