n = gets.to_i
an = n.times.map { gets.to_i }

# 1番大きい値と、2番目に大きい値がわかればおk

sorted = an.sort.reverse

max = sorted.first
is_duplicated = max == sorted[1]
next_max = an.select {|e| e != max }.max

an.each do |a|
    if a != max
        puts max
    elsif is_duplicated
        puts max
    else
        puts next_max
    end
end