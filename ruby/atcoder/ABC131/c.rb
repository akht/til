a, b, c, d = gets.strip.split.map(&:to_i)

# 10^18なので明らかに全探索はできない

# ans = 全体 - (cの倍数の数 + dの倍数の数 - cとdの最小公倍数の倍数の数)

all = b - a + 1
c_mul = b / c - (a - 1) / c
d_mul = b / d - (a - 1) / d
lcm = c.lcm(d)
lcm_mul = b / lcm - (a - 1) / lcm

puts all - (c_mul + d_mul - lcm_mul)