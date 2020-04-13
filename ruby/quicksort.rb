def sorted?(array)
  array.each_cons(2).all? {|a, b| a <= b}
end

def partition(array, left, right)
  pivot = (left + right) / 2
  pv = array[pivot]
  lp = left;
  rp = right;
  while true
    while array[lp] < pv
      lp += 1
    end
    while array[rp] > pv
      rp -= 1
    end
    if lp > rp
      return lp
    end

    tmp = array[lp]
    array[lp] = array[rp]
    array[rp] = tmp

    lp += 1
    rp -= 1
  end
end

def quicksort(array, left, right)
  if left == right
    return
  end
  lp = partition(array, left, right)
  quicksort(array, left, lp-1)
  quicksort(array, lp, right)
end

array = [16, 5, 3, 2, 21, 10, 4, 6, 7, 9, 18]
p array
quicksort(array, 0, array.size - 1)
p array
p sorted?(array)
p "-------------------------------------------------"


def quicksort2(array, left, right)
  if right == left
    return
  end

  p = array[(left + right) / 2]
  l = left
  r = right
  while true
    while array[l] < p
      l += 1
    end
    while array[r] > p
      r -= 1
    end

    if l > r
      break
    end

    array[l], array[r] = array[r], array[l]

    l += 1
    r -= 1
  end

  quicksort2(array, left, l - 1)
  quicksort2(array, l, right)
end

array = [16, 5, 3, 2, 21, 10, 4, 6, 7, 9, 18]
p array
quicksort2(array, 0, array.size - 1)
p array
p sorted?(array)
p "-------------------------------------------------"



