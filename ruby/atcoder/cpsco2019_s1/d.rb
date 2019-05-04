n = gets.to_i

mod = 10 ** 9 + 7

# 繰り返し自乗法(a^b mod pを高速に求める)
def repeated_squaring(a, b, p)
    if b == 0
        1
    elsif b % 2 == 0
        d = repeated_squaring(a, b / 2, p)
        d * d % p
    else
        a * repeated_squaring(a, b - 1, p) % p
    end
end

# 実験してみると、8*5^(n-1)になっていることがわかる
# nが巨大で5**(n-1)が計算できないため繰り返し自乗法を使う

ans = (repeated_squaring(5, n - 1, mod) * 8) % mod
puts ans