a = [1, 2, 3, 4, 5]
a[1..3] #=> [2, 3, 4]

a = 'abcdef'
a[1..3] #=> "bcd"

a = 5
p 0 <= a && a <= 10
p (0..10).include?(a)

def charge(age)
  case age
  when 0..5
    0
  when 6..12
    300
  when 13..18
    600
  else
    1000
  end
end

(1..5).to_a #=> [1, 2, 3, 4, 5]
[*1..5]     #=> [1, 2, 3, 4, 5]

(1...5).to_a #=> [1, 2, 3, 4]
p [*1...5]   #=> [1, 2, 3, 4]

('a'..'e').to_a #=> ["bad", "bae", "baf", "bag"]
[*'a'..'e']     #=> ["bad", "bae", "baf", "bag"]

numbers = []
(1..10).step(2) {|n| numbers << n}
numbers #=> [1, 3, 5, 7, 9]
