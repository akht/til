numbers = [*1..6]

numbers.select { |n| n.even? } #=> [2, 4, 6]
numbers.select(&:even?)

numbers.reject { |n| n.even? } #=> [1, 3, 5]
numbers.reject(&:even?)

numbers.find { |n| n.even? } #=> 2
numbers.find(&:even?)

numbers.inject(0) { |result, n| result + n } #=> 21
numbers.reduce(0) { |result, n| result + n } #=> 21
