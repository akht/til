def sorted?(array)
  array.each_cons(2).all? {|a, b| a <= b}
end

def bubblesort(array)
  array.size.times.each do |i|
    (array.size - 1).times do |j|
      left = array[j]
      right = array[j + 1]
      if left <= right
        next
      end

      array[j], array[j + 1] = array[j + 1], array[j]
    end
  end
end

array = [16, 5, 3, 2, 21, 10, 4, 6, 7, 9, 18]
p array
bubblesort(array)
p array
p sorted?(array)
p "-------------------------------------------------"
