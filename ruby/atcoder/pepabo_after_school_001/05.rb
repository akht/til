def fact(n)
  mod = 10 ** 9 + 7
  ret = 1
  (1..n).each do |i|
    ret = ret * i % mod
  end
  ret
end

n, m = gets.strip.split.map(&:to_i)

small, large = [n, m].sort
fact_l = fact(large)
fact_s = fact(small)

mod = 10 ** 9 + 7

if large - small > 1
  puts 0
elsif large == small
  puts (fact_l * fact_s * 2) % mod
else
  puts (fact_l * fact_s) % mod
end
