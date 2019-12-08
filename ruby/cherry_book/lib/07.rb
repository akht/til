a = [1, 2, 3, 4, 5]
a[1, 3] #=> [2, 3, 4]

a.values_at(0, 2, 4) #=> [1, 3, 5]

a = [1, 2, 3]
a[-2, 2] #=> [2, 3]
a.last #=> 3
a.last(2) #=> [2, 3]
a.first #=> 1
a.first(2) #=> [1, 2]

a = [1, 2, 3, 4, 5]
a[1, 3] = 100
a #=> [1, 100, 5]

a = []
a.push(1) #=> [1]
a.push(2, 3) #=> [1, 2, 3]

a = [1, 2, 3, 1, 2, 3]
a.delete(2) #=> 2
a #=> [1, 3, 1, 3]

a = [1, 2, 3]
b = [3, 4, 5]
a | b #=> [1, 2, 3, 4, 5]
a - b #=> [1, 2]
a & b #=> [3]

e, *f = 100, 200, 300
e #=> 100
f #=> [200, 300]

a = []
b = [2, 3]
a.push(1) #=> [1]
a.push(b) #=> [1, [2, 3]]

a = []
b = [2, 3]
a.push(1) #=> [1]
a.push(*b) #=> [1, 2, 3] splat展開して渡す

# 可変長引数
def greeting(*names)
  "#{names.join('と')}、こんにちは"
end

greeting('田中', '佐藤')

a = [1, 2, 3]
[a] #=> [[1, 2, 3]]
[*a] #=> [1, 2, 3]
[-1, 0, *a, 4, 5] #=> [-1, 0, 1, 2, 3, 4, 5]

[1 ,2, 3] == [1, 2, 3] #=> true
[1, 2, 3] == [1, 3, 2] #=> false

['a', 'b', 'c'] #=> ["a", "b", "c"]
%w!a b c! #=> ["a", "b", "c"]
%w(a b c) #=> ["a", "b", "c"]
%w(
  a
  b
  c
)
#=> ["a", "b", "c"]

prefix = 'This is'
%W(#{prefix}\ an\ apple small\nmelon orange)
#=> ["This is an apple", "small\nmelon", "orange"]




a = Array.new(10) {|n| n % 3 + 1}
a #=> [1, 2, 3, 1, 2, 3, 1, 2, 3, 1]

a = Array.new(5, 'default')
a #=> ["default", "default", "default", "default", "default"]

str = a[0]
str #=> "default"

str.upcase!
str #=> "DEFAULT"

a #=> ["DEFAULT", "DEFAULT", "DEFAULT", "DEFAULT", "DEFAULT"]


a = Array.new(5) {'default'}
a #=> ["default", "default", "default", "default", "default"]

str = a[0]
str #=> "default"

str.upcase!
str #=> "DEFAULT"

a #=> ["default", "default", "default", "default", "default"]

