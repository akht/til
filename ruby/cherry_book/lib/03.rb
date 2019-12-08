a = [1, 2, 3]
a[4] = 50
a #=> [1, 2, 3, nil, 50]

a = [1, 2, 3]
a.delete_at(1) #=> 2
a #=> [1, 3]
a.delete_at(100) #=> nil

a, b = [1, 2]
a #=> 1
b #=> 2

c, d = [10]
c #=> 10
d #=> nil

e, f = [100, 200, 300]
e #=> 100
f #=> 200

14.divmod(3) #=> [4, 2]

quo_rem = 14.divmod(3)
quo_rem #=> [4, 2]

quotient, remainder = 14.divmod(3)
quotient #=> 4
remainder #=> 2
