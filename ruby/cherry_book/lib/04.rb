numbers = [*1..10]
sum = 0
numbers.each do |n|
  sum += n
end

a = [1, 2, 3, 1, 2, 3]
a.delete_if do |n|
  n.odd?
end
a #=> [2, 2]

numbers.each do
  sum += 1
end

numbers.each do |n| sum += n end

numbers.each {|n| sum += n}

numbers.each {|n|
  sum += n
}
