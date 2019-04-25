n = gets.to_i
as = gets.strip.split.map(&:to_i).sort.reverse

alice = 0
bob = 0

until as.empty? do
    alice += as.shift
    break if as.empty?
    bob += as.shift
end

puts (alice - bob)


# n.times do |i|
#     alice += as[i] if i.even?
#     bob += as[i] if i.odd?
# end

# puts alice - bob