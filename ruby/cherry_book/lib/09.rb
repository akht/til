sum = 0
5.times { sum += 1 }

a = []
1.step(10, 2) {|n| a << n}
a #=> [1, 3, 5, 7, 9]

a = []
10.step(1, -2) {|n| a << n}
a #=> [10, 8, 6, 4, 2]

a = []
while a.size < 5
  a << 1
end
a #=> [1, 1, 1, 1, 1]

a = []
while a.size < 5 do a << 1 end
a #=> [1, 1, 1, 1, 1]

a = []
a << 1 while a.size < 5
a #=> [1, 1, 1, 1, 1]


a = []

while false
  a << 1
end
a #=> []

begin
  a << 1
end while false
a #=> [1]


a = [10, 20, 30, 40, 50]
until a.size <= 3
  a.delete_at(-1)
end
a #=> [10, 20, 30]


fruits = ['apple', 'melon', 'orange']
numbers = [1, 2, 3]
catch :done do
  fruits.shuffle.each do |fruit|
    numbers.shuffle.each do |n|
      puts "#{fruit}, #{n}"
      if fruit == 'orange' && n == 3
        throw :done
      end
    end
  end
end


ret = catch :done do
  throw :done, 123
end
p ret


foods = ['ピーマン', 'トマト', 'セロリ']
foods.each do |food|
  print "#{food}は好きですか？(y/N)"
  answer = ['y', 'N'].sample
  puts answer

  redo unless answer == 'y'
end
