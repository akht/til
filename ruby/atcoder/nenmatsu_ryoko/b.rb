# https://atcoder.jp/contests/arc019/tasks/arc019_2

a = gets.strip.chars

if a.size == 1
  puts 0
  exit
end

rev = a.reverse



limit = a.size / 2 - 1
count = (0..limit).to_a.map{|i| a[i] == a[-(i+1)] ? 0 : 1 }.inject(&:+)



ans = 0
if a.size.even?
  if count == 1
    ans =  25 * a.size - 2
  else
    ans = 25 * a.size
  end
else
  if count == 0
    ans = 25 * (a.size - 1)
  elsif count == 1
    ans = 25 * a.size - 2
   else
    ans = 25 * a.size
  end
end

puts ans
