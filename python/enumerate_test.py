# enumerate()をつかえば添え字付きでイテレートできる
# 添え字は0始まり
l = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
tuples = [(i, name) for i, name in enumerate(l)]
print(tuples) # => [(0, 'a'), (1, 'b'), (2, 'c'), (3, 'd'), (4, 'e'), (5, 'f'), (6, 'g')]
