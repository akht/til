s = gets.strip
t = gets.strip

arr = Array.new(26) { Array.new }

# 文字ごとに出現位置を配列として持たせる
s.chars.each_with_index do |c, i|
  arr[c.ord - 'a'.ord] << i + 1
end

cur = 0
count = 0

t.chars.each do |c|
  p = c.ord - 'a'.ord

  if arr[p].empty?
    puts -1
    exit
  end

  # 現在位置より後ろに存在する文字cの位置情報
  cur = arr[p].bsearch { |item| item > cur }

  # 後ろになければ文字列全体を連結して位置を更新
  unless cur
    cur = arr[p].first
    count += 1
  end
end

puts s.length * count + cur