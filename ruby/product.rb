members1 = ["あ", "い", "う"]
members2 = ["a", "b", "c"]
members3 = [1, 2, 3]

def product(*arrays)
  ret = []

  arrays.each do |arr|
    memo = []

    if ret.empty?
      ret = arr
      next
    end

    ret.each do |r|
      arr.each do |e|
        memo << [*r, e]
      end
    end

    ret = memo
  end

  ret
end

product(members1, members2, members3).each {|arr| p arr}
