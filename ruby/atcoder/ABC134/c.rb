n = gets.to_i
an = n.times.map { gets.to_i }

# 1番大きい値と、2番目に大きい値がわかればおk

sorted = an.sort.reverse

max = sorted[0]
next_max = sorted[1]

an.each.map { |a| puts a == max ? next_max : max }