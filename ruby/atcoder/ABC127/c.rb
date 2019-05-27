n, m = gets.strip.split.map(&:to_i)

lhs = 0
rhs = n

m.times {
    l, r = gets.strip.split.map(&:to_i)
    lhs = [l, lhs].max
    rhs = [r, rhs].min
}

d = rhs - lhs + 1
puts d >= 0 ? d : 0
