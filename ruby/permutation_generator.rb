# オリジナル： https://deltam.blogspot.com/2019/06/blog-post.html

def gen_perm(arg_arr)
  ret = []
  arr = Array.new(arg_arr)
  (1..arr.size).inject(1, :*).times do
    ret << Array.new(arr)
    if ruleCheck(arr)
      delta(arr)
    else
      sigma(arr)
    end
  end
  ret
end

def sigma(arr)
  n = arr.size
  f = arr[0]
  arr[0..n - 1] = arr[1..n]
  arr[n - 1] = f
end

def delta(arr)
  n = arr.size
  f0 = arr[0]
  f1 = arr[1]
  arr[0..n - 2] = arr[2..n]
  arr[n - 2] = f1
  arr[n - 1] = f0
end

def ruleCheck(arr)
  n = arr.size

  # rule1
  return false if arr[0] == n

  pos = 0
  n.times do |i|
    if arr[i] == n
      pos = i
      break
    end
  end
  pos += 1
  if pos == n
    pos = 1
  end

  # rule2
  return false if arr[pos] != 1 + (arr[0] - 2 + n - 1) % (n - 1)

  # rule3
  n.times do |i|
    return true if arr[(i + 1) % n] != n - i
  end

  false
end

p gen_perm([2, 3, 1])
p gen_perm([3, 2, 4, 1])
p gen_perm([4, 3, 2, 5, 1])




a = ["a", "b", "c"]
index = [*1..a.size]
index.reverse!
index.rotate!(1)
index[index.size - 1], index[index.size - 2] = index[index.size - 2], index[index.size - 1]

ret = gen_perm(index).map {|idx| idx.map {|i| a[i - 1]}}
p ret
