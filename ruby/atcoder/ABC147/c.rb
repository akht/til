n = gets.to_i
data = []
n.times {
  a = gets.to_i
  tmp = []
  a.times do
    x, y = gets.strip.split.map(&:to_i)
    tmp << [x - 1, y]
  end
  data << tmp
}

ans = 0
[0, 1].repeated_permutation(n) do |bits|
  flg = true
  bits.each_with_index do |bit, i|
    next if bit == 0
    data[i].each do |x, y|
      unless bits[x] == y
        flg = false
      end
    end
  end
  if flg
    ans = [ans, bits.inject(&:+)].max
  end
end

puts ans
